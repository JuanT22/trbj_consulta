---

# Implementación de Integración Numérica: Método de Simpson 1/3

## 1. Descripción General

Este proyecto forma parte de la asignatura de **Programación Funcional y Reactiva**. El objetivo principal es aplicar conocimientos sobre **funciones de orden superior**, específicamente la capacidad de enviar una función como parámetro a otra función.

Para demostrar este concepto, se implementa una solución algorítmica para calcular integrales definidas utilizando el método de aproximación numérica conocido como **Simpson 1/3**.

## 2. Marco Teórico

### Método de Simpson 1/3

La regla de Simpson 1/3 es un método de integración numérica que aproxima el valor de una integral definida mediante polinomios de segundo orden. La fórmula utilizada en este proyecto es la siguiente:

$$
\int_a^b f(x),dx \approx \frac{b-a}{6}\left[f(a)+4f\left(\frac{a+b}{2}\right)+f(b)\right].
$$

Donde:

* **a**: Es el límite inferior de la integral.
* **b**: Es el límite superior de la integral.
* **f(x)**: Es la función matemática a integrar.
* **\overline{x}**: Es el punto medio entre a y b, calculado como:

$$
\overline{x} = \frac{a+b}{2}.
$$

## 3. Análisis y Diseño de la Solución

### Función Principal: `integracion`

De acuerdo con los requerimientos, se ha creado una función llamada `integracion`. Esta función actúa como una **función de orden superior** porque recibe otra función matemática como uno de sus argumentos.

#### Parámetros de entrada:

Para que la función sea genérica y reutilizable, recibe los siguientes parámetros:

1. **Función a integrar (f)**: Una función que toma un valor numérico y devuelve otro.
2. **Límite inferior (a)**: Valor numérico donde inicia la integración.
3. **Límite superior (b)**: Valor numérico donde termina la integración.

#### Tipo de retorno:

* La función devuelve un valor de tipo numérico decimal (`Double`), que representa el área aproximada bajo la curva.

### Cálculo del Margen de Error

Para validar la precisión del método, se implementa una función adicional que calcula el error absoluto entre el valor esperado (matemáticamente exacto o proporcionado) y el valor obtenido por nuestro algoritmo.

La fórmula utilizada es:

$$
\text{Error absoluto} = \left|,\text{Valor esperado} - \text{Valor obtenido},\right|.
$$

## 4. Casos de Prueba

Se han definido 7 ejercicios de integración para validar el funcionamiento del algoritmo. A continuación se presentan las funciones matemáticas y sus valores esperados aproximados:

|  Caso | Función $f(x)$                | Límites $[a, b]$ | Valor Esperado (Aprox.) |
| ----: | ----------------------------- | ---------------- | ----------------------: |
| **1** | $-x^{2} + 8x - 12$            | $[3, 5]$         |                  $7.33$ |
| **2** | $3x^{2}$                      | $[0, 2]$         |                   $8.0$ |
| **3** | $x + 2x^{2} - x^{3} + 5x^{4}$ | $[-1, 1]$        |                 $3.333$ |
| **4** | $\dfrac{2x + 1}{x^{2} + x}$   | $[1, 2]$         |               $1.09861$ |
| **5** | $e^{x}$                       | $[0, 1]$         |               $1.71828$ |
| **6** | $\dfrac{1}{\sqrt{x - 1}}$     | $[2, 3]$         |              $0.828427$ |
| **7** | $\dfrac{1}{1 + x^{2}}$        | $[0, 1]$         |              $0.785398$ |

---

## 5. Conclusiones y Análisis de Resultados

Al ejecutar los casos de prueba y analizar el margen de error calculado mediante la fórmula $\lvert,$ValorEsperado $-$ ValorObtenido$\rvert$, se observan los siguientes comportamientos derivados de la naturaleza del método de Simpson 1/3:

### 1. Precisión en Funciones Polinómicas

El método de Simpson 1/3 basa su funcionamiento en conectar puntos mediante **interpolación parabólica** (polinomios de segundo grado).

* **Resultados Exactos:** En los **Casos 1 y 2**, donde las funciones son polinomios de segundo grado ($x^{2}$), el método es capaz de calcular el área exacta. Si el error no es exactamente $0.0$, será un número extremadamente pequeño (ej. $1.0\times10^{-15}$) debido únicamente a la limitación de precisión de los números flotantes en la computadora, pero matemáticamente el método es exacto para estos casos.

### 2. Aproximación en Funciones Complejas

Para funciones de grado superior (como el **Caso 3** que contiene $x^{4}$) o funciones trascendentes y racionales (como los **Casos 4, 5, 6 y 7** que incluyen $e^{x}$, raíces o divisiones):

* **Presencia de Error:** El método presenta un margen de error visible. Esto ocurre porque estamos intentando aproximar curvas complejas utilizando una sola parábola (intervalo simple).
* **Interpretación:** Aunque el valor obtenido es una aproximación válida, existe una discrepancia con el valor real porque la curvatura de funciones como $e^{x}$ o $1/x$ no se ajusta perfectamente a la forma de una parábola simple en el intervalo evaluado.

### Resumen

La implementación realizada demuestra que el método de Simpson 1/3 es altamente eficiente y preciso para funciones suaves y polinómicas, cumpliendo con el objetivo de aplicar funciones de orden superior para la resolución de problemas matemáticos numéricos.

---
