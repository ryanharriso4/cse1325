#ifndef VENDING_MACHINE_H
#define VENDING_MACHINE_H

class Vending_machine{
private:
	std::vector <Item> items; 

public:
	add(std::string name, int price); 
	buy(int index); 
	std:: string menu(); 
}

#endif