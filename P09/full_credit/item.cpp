#include "item.h"
#include <string>
#include <stdexcept>
#include <stdio.h>

item::item(std::string name, int price)
	:_name{name}, _price{price}{
		if(price < 0) throw std::runtime_error{"Item number invalid"}; 
}

std::string item::to_string(){
	char num [50];
	sprintf(num, "%0.2f", (_price /(double)100));
	//double d = _price / (double)100; 

	std::string temp = _name + " ($" + num + ")\n";
	return temp.c_str();  
}
