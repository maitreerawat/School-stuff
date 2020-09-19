#define LS 3      // left sensor
#define RS 2      // right sensor

/*-------definning Outputs------*/
#define LM1 5      // left motor
#define LM2 6       // left motor
#define RM1 10       // right motor
#define RM2 11       // right motor

void setup()
{
  //Serial.begin(9600);
  pinMode(LS, INPUT);
  pinMode(RS, INPUT);
  pinMode(LM1, OUTPUT);
  pinMode(LM2, OUTPUT);
  pinMode(RM1, OUTPUT);
  pinMode(RM2, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(6, OUTPUT);
  digitalWrite(7,HIGH);
  digitalWrite(6,HIGH);
  
}
int spd = 150;
void loop()
{
  if(!(digitalRead(LS)) && !(digitalRead(RS)))     // Move Forward
  {
    analogWrite(LM1, spd);
    digitalWrite(LM2, LOW);
    analogWrite(RM1, spd);
    digitalWrite(RM2, LOW);
  }
  
  if(!(digitalRead(RS)) && digitalRead(LS))     // Turn right
  {
    digitalWrite(LM1, LOW);
    digitalWrite(LM2, LOW);
    analogWrite(RM1, spd);
    digitalWrite(RM2, LOW);
    spd = 80;
  }
  spd = 150;
  if(digitalRead(RS) && !(digitalRead(LS)))     // turn left
  {
    analogWrite(LM1, spd);
    digitalWrite(LM2, LOW);
    digitalWrite(RM1, LOW);
    digitalWrite(RM2, LOW);
    spd = 80;
  }
  spd = 150;
  if((digitalRead(LS)) && (digitalRead(RS)))     // stop
  {
    digitalWrite(LM1, LOW);
    digitalWrite(LM2, LOW);
    digitalWrite(RM1, LOW);
    digitalWrite(RM2, LOW);
  }
 // Serial.print(digitalRead(LS));
  //Serial.println(digitalRead(RS));
}
