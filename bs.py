lista = [1,2,3,4,5]

buscado = 2

pasos = 0

left = 0
right = len(lista)-1

while(left <= right):
    pasos += 1
    mid = (left+right)//2
    if(lista[mid] == buscado):
        print("Encontrado")
        break
    elif(lista[mid] > buscado):
        right = mid - 1
    else:
        left = mid + 1
print("pasos: ", pasos)
