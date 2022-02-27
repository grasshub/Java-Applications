package org.hong.javafundamental.generics;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class FavoritesImpl implements Favorites {
	private final Map<Class<?>, Object> favorites = new HashMap<>();
			
	@Override
	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		} 
		favorites.put(type, instance);	
	}

	@Override
	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	public static void main(String[] args) {
		Favorites favorites = new FavoritesImpl();
		
		favorites.putFavorite(String.class, "Java");
		favorites.putFavorite(Integer.class, 9);
		favorites.putFavorite(Boolean.class, true);
		favorites.putFavorite(Class.class, Array.class);
		
		String string = favorites.getFavorite(String.class);
		int integer = favorites.getFavorite(Integer.class);
		boolean bool = favorites.getFavorite(Boolean.class);
		Class<?> clazz = favorites.getFavorite(Class.class);
		
		System.out.printf("%s %d %b %s%n", string, integer, bool, clazz);
	}
}
