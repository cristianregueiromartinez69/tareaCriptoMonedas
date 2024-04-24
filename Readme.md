# Enunciado 2: Plataforma de Intercambio de Criptomonedas
## Objetivo:
Crear una aplicación de escritorio para el intercambio de criptomonedas que permita a los usuarios comprar y vender criptomonedas, visualizar precios en tiempo real utilizando una API de mercado de criptomonedas y gestionar su cartera utilizando archivos de texto plano.

## Requisitos:


1. Interfaz de Usuario: Desarrollar una interfaz usando Java Swing que incluya vistas para el intercambio de monedas, consulta de precios actuales, y gestión de cartera de usuario.

2. Conexión con API de Criptomonedas: Integrar la aplicación con una API de mercado de criptomonedas (como CoinGecko o CryptoCompare) para obtener precios en tiempo real.

3. Gestión de Cartera: Permitir a los usuarios ver el detalle de sus carteras, incluyendo las criptomonedas que poseen y su cantidad, utilizando archivos de texto para almacenar y recuperar estos datos.

4. Seguridad: Implementar técnicas básicas de seguridad, como cifrado de archivos, para proteger la información almacenada de los usuarios.

## Ejemplo de Funcionalidad de API:

public void actualizarPrecios() {

    String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

    try {

        URL url = new URL(apiUrl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {

            content.append(inputLine);

        }

        // Procesar JSON y actualizar interfaz aquí

        in.close();

        con.disconnect();

    } catch (IOException e) {

        e.printStackTrace();

    }

}

public void actualizarPrecios() { String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd"; try { URL url = new URL(apiUrl); HttpURLConnection con = (HttpURLConnection) url.openConnection(); con.setRequestMethod("GET"); BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); String inputLine; StringBuffer content = new StringBuffer(); while ((inputLine = in.readLine()) != null) { content.append(inputLine); } // Procesar JSON y actualizar interfaz aquí in.close(); con.disconnect(); } catch (IOException e) { e.printStackTrace(); } }
 