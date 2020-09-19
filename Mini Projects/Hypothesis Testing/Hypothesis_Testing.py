#Hypothesis Testing
import pandas as pd
import numpy as np
from scipy.stats import ttest_ind

states = {'OH': 'Ohio', 'KY': 'Kentucky', 'AS': 'American Samoa', 'NV': 'Nevada', 'WY': 'Wyoming', 'NA': 'National', 'AL': 'Alabama', 'MD': 'Maryland', 'AK': 'Alaska', 'UT': 'Utah', 'OR': 'Oregon', 'MT': 'Montana', 'IL': 'Illinois', 'TN': 'Tennessee', 'DC': 'District of Columbia', 'VT': 'Vermont', 'ID': 'Idaho', 'AR': 'Arkansas', 'ME': 'Maine', 'WA': 'Washington', 'HI': 'Hawaii', 'WI': 'Wisconsin', 'MI': 'Michigan', 'IN': 'Indiana', 'NJ': 'New Jersey', 'AZ': 'Arizona', 'GU': 'Guam', 'MS': 'Mississippi', 'PR': 'Puerto Rico', 'NC': 'North Carolina', 'TX': 'Texas', 'SD': 'South Dakota', 'MP': 'Northern Mariana Islands', 'IA': 'Iowa', 'MO': 'Missouri', 'CT': 'Connecticut', 'WV': 'West Virginia', 'SC': 'South Carolina', 'LA': 'Louisiana', 'KS': 'Kansas', 'NY': 'New York', 'NE': 'Nebraska', 'OK': 'Oklahoma', 'FL': 'Florida', 'CA': 'California', 'CO': 'Colorado', 'PA': 'Pennsylvania', 'DE': 'Delaware', 'NM': 'New Mexico', 'RI': 'Rhode Island', 'MN': 'Minnesota', 'VI': 'Virgin Islands', 'NH': 'New Hampshire', 'MA': 'Massachusetts', 'GA': 'Georgia', 'ND': 'North Dakota', 'VA': 'Virginia'}

def get_list_of_university_towns():
    fh=open('university_towns.txt','r')
    contents=fh.readlines()
    l=[]
    state=''
    region=''
    for line in contents:
        if '[edit]' in line:
            state=line.split('[')[0]
        else:
            region=line.split('(')[0].strip()
            l+=[[state,region]]
    df=pd.DataFrame(l,columns=["State", "RegionName"])
    return df

def get_recession_start():
    energy = pd.read_excel("gdplev.xls",skiprows =230,names=['a','b','c','d','Year','g','GDP','h']).drop(['a','b','c','d','h','g'],axis=1)
    energy['sub']=energy['GDP'].diff()
    energy['RecessionStart'] = (energy['sub'] < 0) & (energy['sub'].shift(-1) < 0)
    return(energy.where(energy['RecessionStart']==True).dropna().reset_index())['Year'].loc[0]

def get_recession_end():
    energy = pd.read_excel("gdplev.xls",skiprows =230,names=['a','b','c','d','Year','g','GDP','h']).drop(['a','b','c','d','h','g'],axis=1)
    energy['sub']=energy['GDP'].diff()
    energy['RecessionStart'] = (energy['sub'] < 0) & (energy['sub'].shift(-1) < 0)
    a=(energy.where(energy['RecessionStart']==True).dropna())['RecessionStart'].idxmin()
    energy=energy[a:]
    energy['RecessionEnd'] = (energy['sub'] > 0) & (energy['sub'].shift(+1) > 0)
    b=(energy.where(energy['RecessionEnd']==True).dropna().reset_index())['Year'].loc[0]
    return(b)

def get_recession_bottom():
    energy = pd.read_excel("gdplev.xls",skiprows =230,names=['a','b','c','d','Year','g','GDP','h']).drop(['a','b','c','d','h','g'],axis=1)
    energy['sub']=energy['GDP'].diff()
    energy['RecessionStart'] = (energy['sub'] < 0) & (energy['sub'].shift(-1) < 0)
    a=(energy.where(energy['RecessionStart']==True).dropna())['RecessionStart'].idxmin()
    energy=energy[a:].reset_index()
    energy['RecessionEnd'] = (energy['sub'] > 0) & (energy['sub'].shift(+1) > 0)
    m=energy[:(energy.where(energy['RecessionEnd']==True).dropna())['RecessionStart'].idxmin()]['GDP'].idxmin()
    return(energy['Year'].loc[m])


def convert_housing_data_to_quarters():
    housing=pd.read_csv('City_Zhvi_AllHomes.csv',usecols=['RegionName','State'])[['RegionName','State']]
    housing2=pd.read_csv('City_Zhvi_AllHomes.csv').filter(regex=("200?.*"))
    housing2.columns = pd.to_datetime(housing2.columns).to_period('M')
    housing['State'].replace(states,inplace=True)
    housing2 = housing2.resample('Q',axis=1).mean()
    housing2= housing2.rename(columns=lambda x: str('{:}q{:}'.format(x.year,x.quarter)))
    housing=pd.merge(housing,housing2,how='outer',left_index=True,right_index=True).set_index(['State','RegionName'])
    return housing


hdf = convert_housing_data_to_quarters().sort_values(by=['State','RegionName'])
rec_start=get_recession_start()
rec_bottom = get_recession_bottom()
ul = get_list_of_university_towns().reset_index()
rec_bf=rec_start[:4]+'q'+str(int(rec_start[5:])-1)
hdf['PriceRatio'] = hdf[rec_bf].div(hdf[rec_bottom])
g1=pd.merge(hdf,ul,
     on=['State','RegionName'],
     how='inner'
     ).set_index(['State','RegionName']).dropna()
g2=hdf[hdf.index.isin(g1.index) == False].dropna()
stat,pvalue=ttest_ind(g1['PriceRatio'], g2['PriceRatio'])
different=pvalue<0.01
better=["university town","non-university town"][g1['PriceRatio'].mean()>g2['PriceRatio'].mean()]
print((different,pvalue,better))


