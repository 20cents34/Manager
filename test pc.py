from tkinter import *
from bluetooth import *


# VAR INIT


Fen_principale = Tk()
# MENU INIT

MenuBar = Menu(Fen_principale)
Option = Menu(MenuBar, tearoff=0)
Aide = Menu(MenuBar, tearoff=0)

#Option.add_command(label="Bluetooth", command=donothing)
Option.add_command(label="Quitter", command=Fen_principale.quit)
MenuBar.add_cascade(label ="Options",menu=Option)
MenuBar.add_cascade(label ="Aide",menu=Aide)
#Aide.add_command(label="A Propos", command=donothing)
# TABLE INIT

Table1 = LabelFrame(Fen_principale,text = 'Table 1',height = 400,width = 400,padx=10, pady=10)
Table1.pack_propagate(0)
Table1.grid(row = 0, column = 0,padx=10, pady=10)

Table2 = LabelFrame(Fen_principale,text = 'Table 2',height = 400,width = 400,padx=10, pady=10)
Table2.pack_propagate(0)
Table2.grid(row = 0, column = 1,padx=10, pady=10)

Table3 = LabelFrame(Fen_principale,text = 'Table 3',height = 400,width = 400,padx=10, pady=10)
Table3.pack_propagate(0)
Table3.grid(row = 0, column = 2,padx=10, pady=10)

Table4 = LabelFrame(Fen_principale,text = 'Table 4',height = 400,width = 400,padx=10, pady=10)
Table4.pack_propagate(0)
Table4.grid(row = 1, column = 0,padx=10, pady=10)

Table5 = LabelFrame(Fen_principale,text = 'Table 5',height = 400,width = 400,padx=10, pady=10)
Table5.pack_propagate(0)
Table5.grid(row = 1, column = 1,padx=10, pady=10)

Table6 = LabelFrame(Fen_principale,text = 'Table 6',height = 400,width = 400,padx=10, pady=10)
Table6.pack_propagate(0)
Table6.grid(row = 1, column = 2,padx=10, pady=10)

ListBox = Listbox(Table1)
ListBox.pack(fill = BOTH, expand = TRUE,pady=(0,10))
ListBox.insert(0, "a list entry")
ListBox.insert(1, "a list entry")
Lab1 = Label(Table1)
Lab1.config(text = "TOTAL : " + str(10) + " € ")
Lab1.pack(side = BOTTOM)

Fen_principale.config(menu=MenuBar)
Fen_principale.mainloop()
