#ifndef __ITEM_H
#define __ITEM_H

class Item {
private:
	std::string _name;
	int _price; 

public:
	Item(std::string name, int price); 
	std::string to_string(); 
}

#endif