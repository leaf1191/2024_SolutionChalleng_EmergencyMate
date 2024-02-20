#include <PulseSensorPlayground.h>     // Includes the PulseSensorPlayground Library.   

//  Variables
const int PulseWire = 0;       
const int LED = LED_BUILTIN;    
int Threshold = 550;        
                               
PulseSensorPlayground pulseSensor;  


void setup() {   

  Serial.begin(9600);   

  // Configure the PulseSensor object, by assigning our variables to it. 
  pulseSensor.analogInput(PulseWire);   
  pulseSensor.blinkOnPulse(LED);  
  pulseSensor.setThreshold(Threshold);   

  // Double-check the "pulseSensor" object was created and "began" seeing a signal. 
   if (pulseSensor.begin()) {
    Serial.println("We created a pulseSensor Object !"); 
  }
}



void loop() {

 

if (pulseSensor.sawStartOfBeat()) {            
int myBPM = pulseSensor.getBeatsPerMinute();  
 Serial.println(myBPM);                       
}

  delay(20);            

}

  
