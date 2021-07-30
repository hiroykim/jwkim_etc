#include <stdio.h>

void main()
{
  print("Warning : Don`t Run Me!");
  
  setreuid(0,0);
  setregid(0,0);
  system("/usr/bin/bash");
}
