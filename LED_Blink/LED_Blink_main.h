#include <16F18877.h>
#device ADC=10
#device ICSP=1
#use delay(internal=32000000)

//!#FUSES NOWDT                    //No Watch Dog Timer
//!#FUSES CKSFSM                   //Clock Switching is enabled, fail Safe clock monitor is enabled
//!#FUSES NOBROWNOUT               //No brownout reset
//!#FUSES BORV_LOW                 //Brown-out Reset set to lowest voltage

#define LED1 PIN_B2
#define DELAY1 200
#define LED2 PIN_B1

#define LED3 PIN_C7

#define LED4 PIN_C6





