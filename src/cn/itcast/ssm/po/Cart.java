package cn.itcast.ssm.po;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart{
	
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	double total;
	
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	public double getTotal() {
		return total;
	}

	public void addCart(CartItem cartItem){
		Integer pid=cartItem.getPid();
		if(map.containsKey(pid)){
			CartItem _cartItem=map.get(pid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			total+=cartItem.getSubtotal();
		}else{
			map.put(pid, cartItem);
			total+=cartItem.getSubtotal();
		}
	}
	
	public void removeCart(Integer pid) {
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}

	public void clearCart() {
		map.clear();
		total = 0;
	}
}
