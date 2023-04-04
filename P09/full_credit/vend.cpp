#include "item.h"
#include "vending_machine.h"
#include <iostream>

int main(){ 
	vending_machine* vm = new vending_machine(); 
	vm->add("Oreos", 199);
	vm->add("Chips", 180);
	std::cout << vm->menu() << std::endl; 
	vm->buy(0); 

}