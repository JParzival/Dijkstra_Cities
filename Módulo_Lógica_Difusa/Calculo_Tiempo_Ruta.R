##Primero voy a definir las funciones, basadas en sistemas de ecuaciones

#Verde (Ruta Corta)

## - 1                 --> x <= 75
## - (200-x) / (200-75) --> 75 < x <= 200
## - 0                 --> 200 < x

#Negro (Ruta Media)

## - (x-150) / (250-150) --> 150 <= x <= 250
## - 1                   --> 250 < x <= 350
## - (400-x) / (400-350) --> 350 < x <= 400

#Rojo (Ruta Larga)

## - 0                 --> x <= 350
## - (x-350)/(450-350) --> 350 < x <= 450
## - 1                 --> 450 < x

## Ahora lo que voy a hacer es calcular la función general a la que llamaremos desde el cÃ³digo.

x = seq(0, 600, by=1)

calcular_funcion_pertenencia <- function(x, tipo, a, b, c, d)
{
  
  mu_x = rep(0, length(x))
  
  if( tipo == 'corta')
  {
    mu_x[x <= a] <- 1
    mu_x[x <= b & x >= a] <- (b-x[x <= b & x >= a])/(b-a)
  }
  
  if( tipo == 'media')
  {
    mu_x[x >= a & x <= b] <- (x[x >= a & x <= b] - a) / (b-a)
    mu_x[x >= b & x <= c] <- 1
    mu_x[x <= d & x >= c] <- (d-x[x <= d & x >= c])/(d-c)
  }
  
  if( tipo == 'larga' )
  {
    mu_x[x<=a]            <- 0
    mu_x[x >= a & x <= b] <- (x[x >= a & x <= b] - a) / (b-a)
    mu_x[x >= b]          <- 1
  }
  
  resultado_func_pertenencia <- list(x=x, tipo=tipo, a=a, b=b, c=c, d=d, mu_x=mu_x)
}

resultado <- calcular_funcion_pertenencia(x, 'corta', 75, 200, 0, 0)
resultado2 <- calcular_funcion_pertenencia(x, 'media', 150, 250, 350, 400)
resultado3 <- calcular_funcion_pertenencia(x, 'larga', 350, 450, 0, 0)

plot(x, resultado$mu_x, lwd = 3, type="l", main="Lógica Difusa Creencia Viaje", xlim=c(0, 600), col="green")
lines(x, resultado2$mu_x, lwd = 3, col="black")
lines(x, resultado3$mu_x, lwd = 3, col = "red")