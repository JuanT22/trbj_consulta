object SimpsonIntegration {

  /**
   * 1. Función de Orden Superior: integracion
   * Calcula la integral definida usando el método de Simpson 1/3.
   *
   * @param f Función a integrar (Double => Double) -> Se pasa como parámetro [cite: 6, 15]
   * @param a Límite inferior
   * @param b Límite superior
   * @return Aproximación del área bajo la curva
   */
  def integracion(f: Double => Double, a: Double, b: Double): Double = {
    val x_barra = (a + b) / 2 // 
    val resultado = (b - a) * (f(a) + 4 * f(x_barra) + f(b)) / 6 // 
    resultado
  }

  /**
   * 3. Función para calcular el error
   * Calcula el error absoluto entre el valor esperado y el obtenido.
   * Fórmula: |valorEsperado - valorObtenido| [cite: 28, 29]
   */
  def calcularError(valorEsperado: Double, valorObtenido: Double): Double = {
    Math.abs(valorEsperado - valorObtenido)
  }

  def main(args: Array[String]): Unit = {
    // Definición de las funciones de los 7 casos de prueba [cite: 20-26]
    val fn1 = (x: Double) => -Math.pow(x, 2) + 8 * x - 12
    val fn2 = (x: Double) => 3 * Math.pow(x, 2)
    val fn3 = (x: Double) => x + 2 * Math.pow(x, 2) - Math.pow(x, 3) + 5 * Math.pow(x, 4)
    val fn4 = (x: Double) => (2 * x + 1) / (Math.pow(x, 2) + x)
    val fn5 = (x: Double) => Math.exp(x)
    val fn6 = (x: Double) => 1 / Math.sqrt(x - 1)
    val fn7 = (x: Double) => 1 / (1 + Math.pow(x, 2))

    // Lista de pruebas (Función, a, b, Valor Esperado)
    val pruebas = List(
      (fn1, 3.0, 5.0, 7.33),      // Caso 1
      (fn2, 0.0, 2.0, 8.0),       // Caso 2
      (fn3, -1.0, 1.0, 3.333),    // Caso 3
      (fn4, 1.0, 2.0, 1.09861),   // Caso 4
      (fn5, 0.0, 1.0, 1.71828),   // Caso 5
      (fn6, 2.0, 3.0, 0.828427),  // Caso 6
      (fn7, 0.0, 1.0, 0.785398)   // Caso 7
    )

    println(f"${"Caso"}%5s | ${"Valor Esperado"}%15s | ${"Valor Obtenido"}%15s | ${"Error"}%15s")
    println("-" * 60)

    // Ejecución y formateo de resultados
    for ((f, a, b, esperado) <- pruebas) {
      val obtenido = integracion(f, a, b)
      val error = calcularError(esperado, obtenido)
      
      // Imprimimos el índice de la prueba basándonos en su posición en la lista
      val index = pruebas.indexOf((f, a, b, esperado)) + 1
      
      println(f"$index%5d | $esperado%15.6f | $obtenido%15.6f | $error%15.6f")
    }
  }
}