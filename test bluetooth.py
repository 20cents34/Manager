import bluetooth
from bluetooth.btcommon import *

uuid = "00001101-0000-1000-8000-00805F9B34FB"
server_sock = bluetooth.BluetoothSocket( bluetooth.RFCOMM )

server_sock.bind(("",PORT_ANY))
server_sock.listen(1)

bluetooth.advertise_service(server_sock, "",service_id = uuid,service_classes = [uuid, SERIAL_PORT_CLASS],profiles = [SERIAL_PORT_PROFILE])

client_sock,address = server_sock.accept()
print ("Accepted connection from ",address)


client_sock.close()
server_sock.close()
