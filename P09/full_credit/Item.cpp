#include Item.h

class Item{
	private: 
		std::string _name;
		int _price; 

	public:
		Item(std::string name, int price)
		:_name{name}, _price{price}{
			if(price < 0) throw std::runtime_error{"Item number invalid"}; 
		}

		std::string to_string(){
			double d = (double)_price / 100; 
			std::cout << _name << "($" << d << ")" << std::endl; 
		}
}