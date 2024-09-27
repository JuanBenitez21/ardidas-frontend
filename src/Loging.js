import React, { useState } from 'react';
import './Loging.css';
import { Header } from './Header';

export default function Loging() {
    
    const [showPassword, setShowPassword] = useState(false);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    // Handle login logic here
    console.log('Login submitted', { email, password });
  };

  return (
    <>
        <Header />
    
    <div className="login-container">
      <div className="login-card">
        <h2 className="login-title">Acceder</h2>
        <p className="login-description">Introduzca sus credenciales para acceder a su cuenta</p>
        <form onSubmit={handleSubmit} className="login-form">
          <div className="form-group">
            <label htmlFor="email" className="form-label">Email</label>
            <input
              id="email"
              type="email"
              placeholder="Ingresa tu email"
              required
              className="form-input"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className="form-group">
            <label htmlFor="password" className="form-label">Contraseña</label>
            <div className="password-input-container">
              <input
                id="password"
                type={showPassword ? "text" : "password"}
                placeholder="Ingresa tu contraseña"
                required
                className="form-input"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              <button
                type="button"
                onClick={() => setShowPassword(!showPassword)}
                className="password-toggle"
              >
                {showPassword ? "Hide" : "Show"}
              </button>
            </div>
          </div>
          <button type="submit" className="login-button">Acceder</button>
        </form>
        <p className="signup-link">
          Eres un cliente nuevo?{" "}
          <a href="/Registro">Sign up</a>
        </p>
        <p className="back-Home">
            <a href="/">Regresar</a>
        </p>
      </div>
    </div>
    </>
  );
}

export {Loging}