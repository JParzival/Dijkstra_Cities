import requests
import json

distancias = \
{
    "salamanca": \
    {
        "valladolid":None,
        "madrid":None
    },
    "valladolid": \
    {
        "madrid": None,
        "zaragoza": None
    },
    "madrid": \
    {
        "zaragoza": None,
        "valencia": None
    },
    "zaragoza": \
    {
        "valencia": None
    }
}

# Distancia ente Salamanca y Valladolid
r = requests.get("http://rutero.gpsitrack.com/route/v1/driving/-5.6802244,40.9559681;-4.7285413742,41.6522966863625")

jsonObtenido = json.loads(r.text)

rutas = jsonObtenido["routes"]
distancia = rutas[0]["distance"] / 1000

print("Salamanca a Valladolid: " + str(distancia))
distancias["salamanca"]["valladolid"] = distancia

# Distancia ente Salamanca y Madrid
r = requests.get("http://rutero.gpsitrack.com/route/v1/driving/-5.6802244,40.9559681;-3.70325,40.4167")

jsonObtenido = json.loads(r.text)

rutas = jsonObtenido["routes"]
distancia = rutas[0]["distance"] / 1000

print("Salamanca a Madrid: " + str(distancia))
distancias["salamanca"]["madrid"] = distancia

# Distancia ente Valladolid y Madrid
r = requests.get("http://rutero.gpsitrack.com/route/v1/driving/-5.6802244,40.9559681;-3.70325,40.4167")

jsonObtenido = json.loads(r.text)

rutas = jsonObtenido["routes"]
distancia = rutas[0]["distance"] / 1000

print("Valladolid a Madrid: " + str(distancia))
distancias["valladolid"]["madrid"] = distancia

# Distancia ente Valladolid y Zaragoza
r = requests.get("http://rutero.gpsitrack.com/route/v1/driving/-5.6802244,40.9559681;-0.876566,41.6563497")

jsonObtenido = json.loads(r.text)

rutas = jsonObtenido["routes"]
distancia = rutas[0]["distance"] / 1000

print("Valladolid a Zaragoza: " + str(distancia))
distancias["valladolid"]["zaragoza"] = distancia

# Distancia ente Madrid y Zaragoza
r = requests.get("http://rutero.gpsitrack.com/route/v1/driving/-3.70325,40.4167;-0.876566,41.6563497")

jsonObtenido = json.loads(r.text)

rutas = jsonObtenido["routes"]
distancia = rutas[0]["distance"] / 1000

print("Madrid a Zaragoza: " + str(distancia))
distancias["madrid"]["zaragoza"] = distancia

# Distancia ente Madrid y Valencia
r = requests.get("http://rutero.gpsitrack.com/route/v1/driving/-3.70325,40.4167;-0.3545661,39.4561165")

jsonObtenido = json.loads(r.text)

rutas = jsonObtenido["routes"]
distancia = rutas[0]["distance"] / 1000

print("Madrid a Zaragoza: " + str(distancia))
distancias["madrid"]["valencia"] = distancia

# Distancia ente Zaragoza y Valencia
r = requests.get("http://rutero.gpsitrack.com/route/v1/driving/-0.876566,41.6563497;-0.3545661,39.4561165")

jsonObtenido = json.loads(r.text)

rutas = jsonObtenido["routes"]
distancia = rutas[0]["distance"] / 1000

print("Madrid a Zaragoza: " + str(distancia))
distancias["zaragoza"]["valencia"] = distancia

with open('distancias.json', 'w') as file:
    json.dump(distancias, file)


exit(0)
