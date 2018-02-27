#include <LED_Blink_main.h>

void main()
{

   int counter2 = 0;
   int counter3 = 0;
   int counter4 = 0;
   //Example blinking LED program
   while(true)
   {
      
      
      
      output_low(LED1);
      delay_ms(DELAY1);
      counter2 = counter2 + 1;
      counter3 = counter3 + 1;
      counter4 = counter4 + 1;
      if(counter2 == 2)
      {
         output_toggle(LED2);
         counter2 = 0;
      }
      if(counter3 == 4)
      {
         output_toggle(LED3);
         counter3 = 0;
      }
      if(counter4 == 8)
      {
         output_toggle(LED4);
         counter4 = 0;
      }
      output_high(LED1);
      delay_ms(DELAY1);
      counter2 = counter2 + 1;
      counter3 = counter3 + 1; 
      counter4 = counter4 + 1;
      if(counter2 == 2)
      {
         output_toggle(LED2);
         counter2 = 0;
      }
      if(counter3 == 4)
      {
         output_toggle(LED3);
         counter3 = 0;
      }
      if(counter4 == 8)
      {
         output_toggle(LED4);
         counter4 = 0;
      }
   }
}


