#ifndef __ITEM_H
#define __ITEM_H

#include <string>

class item {
private:
	std::string _name;
	int _price; 

public:
	item(std::string name, int price); 
	std::string to_string(); 
};

#endif
