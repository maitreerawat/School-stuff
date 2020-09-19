//Tic Tac Toe
#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<conio.h>
struct player
{
    char p[30];
    char c;
    int pos;
};
void initi(char [3][3]);
void call(char [3][3],struct player current);
void draw(char [3][3]);
void game(char [3][3],struct player X,struct player O);
int check(struct player *A);

main()
{ struct player X,O;
  char arr[3][3],ch[30],c=10;
  int val;
  do
  {
 initi(arr);
 X.c='x',O.c='o',X.pos=2,O.pos=2;
 printf("\n\n\n\t\t\t\tWelcome to Tic Tac Toe\n\n");
 do
 {
 while((check(&X)==0));
 while((check(&O)==0));
 if(strcmp(O.p,X.p)==0)
    printf("\n\t\tCannot Have Same Names.\n\t\tEnter Again\n");
 }while(strcmp(O.p,X.p)==0);

 do
    {
        printf("\n\t\tWho plays first,%s or %s?\n\t\t",X.p,O.p);
        gets(ch);
        if((strcmp(X.p,ch)==0)||(strcmp(O.p,ch)==0))
           {
             if(strcmp(X.p,ch)==0)
                X.pos=1;
              else
                O.pos=1;
           }
        else
         printf("\n\t\t%s is not a registered player.",ch);
    } while(!((strcmp(X.p,ch)==0)||(strcmp(O.p,ch)==0)));

 game(arr,X,O);
 do{
 printf("\n\t\tWould you like to play again?\n\t\tPressY/N:-");
 gets(ch);
 if((strcmp(ch,"Y")!=0)&&(strcmp(ch,"N")!=0))
    printf("\n\t\t%s is not a valid answer(Press Enter)",ch);
 if(strcmp(ch,"N")==0)
        printf("\n\t\tBye");
 } while((strcmp(ch,"Y")!=0)&&(strcmp(ch,"N")!=0));
  }while(strcmp(ch,"Y")==0);
}
void initi(char arr[3][3])
{ int i,j,n=1;
   for(i=0;i<3;i++)
    for(j=0;j<3;j++,n++)
        arr[i][j]=n;
}

void draw(char arr[3][3])
{
  int i,j;
  for(i=0;i<3;i++)
   {  printf("\n\t\t\t\t");
       for(j=0;j<3;j++)
  {
      if((arr[i][j]=='x')||(arr[i][j]=='o'))
            printf("  %c",arr[i][j]);
      else
         printf("  .",arr[i][j]);
  }

   }
   printf("\n");
}
void game(char arr[3][3],struct player X,struct player O)
{   int c=0,counter,i,j,temp;
    struct player current;
    char val;
    current=X.pos<O.pos?X:O;
    while(c<=9)
    {
    draw(arr);
      printf("\n\t\tPlayer of Current Turn: %s",current.p);
      call(arr,current);
      c++;
      val=current.c;
    if(c>=5)
      {  counter=0;
         if((val==arr[0][0])&&(val==arr[1][1])&&(val==arr[2][2])||(val==arr[0][2])&&(val==arr[1][1])&&(val==arr[2][0]))
            {counter=1;
            }
          else
          {
              for(i=0,j=0;i<3;i++)
              {
                  temp=arr[i][j];
                  if((temp==arr[i][j+1])&&(temp==arr[i][j+2]))
                   {
                       counter=1;
                       goto label2;
                   }

              }
              for(i=0,j=0;j<3;j++)
              {
                  temp=arr[i][j];
                  if((temp==arr[i+1][j])&&(temp==arr[i+2][j]))
                   {
                       counter=1;
                       goto label2;
                   }

              }
          }
          label2:
         if(counter==1)
            {   draw(arr);
                printf("\n\t\tGame Over!");
                printf("\n\t\t%s wins", current.p );
                goto label1;
             }

      }
    current=strcmp(current.p,X.p)==0?O:X;
    if(c==9)
    { draw(arr);
     printf("\n\t\tGame Over!");
     printf("\n\t\tIt's a tie!!");
     goto label1;
    }
    }
label1:
printf("\n");
}
void call(char arr[3][3],struct player current)
{  int i,j;
   char a[10];
   do
   { label:
    printf("\n\n\t\tChoose a row number 0-2:-");
    gets(a);
     if(!((a[0]=='0')||(a[0]=='1')||(a[0]=='2')))
    { printf("\n\t\tNot a valid row.PLEASE ENTER AGAIN");
    }
    i=a[0];
    i-=48;
   } while((i<0)||(i>2));
    do
   {
    printf("\n\t\tChoose a column number 0-2:-");
    gets(a);
    if(!((a[0]=='0')||(a[0]=='1')||(a[0]=='2')))
    printf("\n\t\tNot a valid column.PLEASE ENTER AGAIN");
    j=a[0];
    j-=48;
    if((arr[i][j]=='x')||(arr[i][j]=='o'))
    {
     printf("\n\t\tThis block has already been chosen.\n\t\tChose another");
     goto label;
    }
   } while(((j<0)||(j>2))||((arr[i][j]=='x')||(arr[i][j]=='o')));
    arr[i][j]=current.c;
}

int check(struct player *A)
{   struct player copy;
    copy=*A;
    printf("\n\t\tEnter a name for %c Player:\n\t\t",copy.c);
    gets(copy.p);
    if(copy.p[0]<33)
        { printf("\n\t\tNot a valid name");
         return(0);
        }
    else
    {
        *A=copy;
        return(1);
    }
}
