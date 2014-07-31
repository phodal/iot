int ledPort=13;

void setup() {
  Serial.begin(9600);
  pinMode(ledPort,OUTPUT);
}

int serialData;
void loop() {
  String inString = "";
  while (Serial.available()> 0)
  {
    int inChar = Serial.read();
    if (isDigit(inChar)) {
      inString += (char)inChar; 
    }
    serialData=inString.toInt();
    Serial.print(serialData);
  }
  if(serialData==1){
    digitalWrite(ledPort,HIGH);
  }else{
    digitalWrite(ledPort,LOW);
  }
}
