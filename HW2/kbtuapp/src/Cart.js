import React, { useContext } from 'react';
import { CartContext } from './CartContext';

function Cart() {
  const { cart, removeFromCart } = useContext(CartContext);

  return (
    <div>
      <h2>Корзина</h2>
      <ul>
        {cart.map((product) => (
          <li key={product.id}>
            <h3>{product.name}</h3>
            <p>Цена: ${product.price}</p>
            <button onClick={() => removeFromCart(product.id)}>Удалить из корзины</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Cart;