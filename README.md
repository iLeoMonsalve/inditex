# Inditex Prices API


## Descripción

Este proyecto es una **API de precios** desarrollada como parte de una prueba técnica para **Inditex**. El objetivo principal de esta API es ofrecer información sobre los precios de productos en diferentes franjas horarias y listas de precios.

La API permite consultar el precio de un producto específico en función de la fecha y el canal de ventas (brand), devolviendo el precio correcto que debe aplicarse para esa combinación de variables.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **Maven** como herramienta de construcción
- **JUnit y Mockito** para pruebas unitarias
- **H2 Database** como base de datos en memoria para pruebas

## Instalación y Ejecución

### Prerrequisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- **Java 17** o superior
- **Maven** (o puedes usar un IDE que soporte Maven como IntelliJ IDEA o Eclipse)

### Clonar el repositorio

Primero, clona el repositorio a tu máquina local utilizando el siguiente comando:

```bash
git clone https://github.com/iLeoMonsalve/inditex.git
```
1. Navega al directorio del proyecto:
    ```bash
    cd inditex
    ```
2. Compila el proyecto usando Maven:
    ```bash
    mvn clean install
   ```
   
## Ejecución

Para ejecutar la aplicación localmente, puedes usar el siguiente comando:
```bash
mvn spring-boot:run
```

## Uso de la API

Una vez que la aplicación esté en funcionamiento, puedes utilizar los endpoints de la API para consultar los precios de productos en función de ciertos parámetros.

### Endpoint principal

- **GET** `/api/prices`
    - **Descripción:** Devuelve el precio de un producto en función de la fecha y el canal de ventas.
    - **Parámetros:**
        - `productId`: ID del producto
        - `brandId`: ID del canal de ventas (Brand)
        - `applicationDate`: Fecha de consulta (formato: `yyyy-MM-dd-HH.mm.ss`)
    - **Ejemplo de solicitud:**

      ```bash
      curl --location 'localhost:8080/api/v1/product?date=2020-06-14-00.00.00&productIdentifier=35455&brand=ZARA'
      ```
