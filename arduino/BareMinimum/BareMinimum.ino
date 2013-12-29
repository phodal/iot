
void setup() {
  Serial.begin(9600);
  pinMode(13,OUTPUT);
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
    digitalWrite(13,HIGH);
  }else{
    digitalWrite(13,LOW);
  }
}
