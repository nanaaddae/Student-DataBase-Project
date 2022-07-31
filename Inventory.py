import tkinter as tk                                #Work in Progress.......
from tkinter import ttk

class Login(tk.Tk):

    def __init__(self):
        super().__init__()

        self.title("Layman's Tools")

        self.geometry("800x600")

        self.configure(bg = "Blue")

        self.label = ttk.Label(self,text="Layman Tools Inventory Management")

        self.label.pack()

        self.user = ttk.Label(self,text = "User")

        self.user.place(x = 250,y = 200)

        self.user.configure(background = "blue")

        self.User =tk.Text(height =1,width = 25)

        self.User.place(x = 320 ,y =200 )

        self.password = ttk.Label(self,text = "Password")

        self.password.place(x=250,y=270)

        self.password.configure(background = "blue")

        self.Password = tk.Text(height = 1, width = 25)

        self.Password.place(x =320,y= 270)

        self.login = ttk.Button(text = "Login")

        self.login.place(x = 360,y = 370)

        self.option = ttk.Radiobutton(self,text = "Admin").place(x =500,y=320 ) # Admin RadioButton

        self.option = ttk.Radiobutton(self,text="Manager").place(x = 250,y=320) # Manager RadioButton

        self.new_admin = ttk.Button(text = "Create new Admin Account").place(x = 360,y=400)

        self.new_manager = ttk.Button(text = " Create new Manager Account").place(x=360,y=430)






class Emp_Page(tk.Tk):

    def __init__(self):
        super().__init__()

        self.title("Admin Page")

        self.geometry("800x600")

        self.configure(bg="Blue")



    pass

class Manager_Page(tk.Tk):

    def __init__(self):
        super().__init__()

        self.title("Admin Page")

        self.geometry("800x600")

        self.configure(bg="Blue")

main_app = Login()
main_app.mainloop()

#logged_in = Emp_Page()
#logged_in.mainloop()



