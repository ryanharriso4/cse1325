#include "vending_machine.h"
#include "item.h"
#include <vector>
#include <string>
#include <iostream>


void vending_machine::add(std::string name, int price){
	item* i = new item(name, price); 
	items.push_back(*i); 

}

void vending_machine::buy(int index){
	std::cout << "#### Buying " << items.at(index).to_string(); 
}

std::string vending_machine::menu()
{
	std::string menu; 
	for(int i = 0; i < items.size(); i++)
	{
		//std::cout << i << ") " << items.at(i).to_string() << std::endl;
		menu += std::to_string(i) + ") " + items.at(i).to_string(); 
	}
	return menu;
}
