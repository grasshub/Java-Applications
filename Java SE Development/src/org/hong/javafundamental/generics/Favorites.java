package org.hong.javafundamental.generics;

public interface Favorites {
	// Typesafe heterogeneous container pattern 
	// It contains different type of class and its value.
	<T> void putFavorite(Class<T> type, T instance);
	<T> T getFavorite(Class<T> type);
}
