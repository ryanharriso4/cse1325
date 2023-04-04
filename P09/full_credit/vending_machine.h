#include <string>
#include <vector>
#include "item.h"
#ifndef VENDING_MACHINE_H
#define VENDING_MACHINE_H

class vending_machine{
private:
	std::vector <item> items; 

public:
	void add(std::string name, int price); 
	void buy(int index); 
	std:: string menu(); 
};

#endif