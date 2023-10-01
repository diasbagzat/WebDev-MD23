import React, { useContext } from 'react';
import { ProductContext } from './ProductContext';
import './ProductList.css'; 
import { CartContext } from './CartContext';

function ProductList() {
    const { products } = useContext(ProductContext);
    const { addToCart } = useContext(CartContext); // Получаем функцию addToCart из контекста корзины
  
    return (
      <div>
        <h2>Список товаров</h2>
        <ul className="product-list">
          {products.map((product) => (
            <li key={product.id} className="product">
              <h3>{product.name}</h3>
              <p>Цена: ${product.price}</p>
              <button onClick={() => addToCart(product)}>Добавить в корзину</button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
  
  export default ProductList;