var app = new Vue({
  el: '#app',
  data: {
    errorMsg: "",
    successMsg: "",
    showAddModal: false,
    showEditModal: false,
    showDeleteModal: false,
    users: [],
    newUser: {firstName:"", lastName:"", patronymic:"", email:"", phoneNum:"", country:"", city:"" },
    currentUser: {},
    countries: [],
    selectedCities: [],
    cities: [],
    country: '',
    error: [],
  },
  mounted: function(){
    this.getAllUsers();
  },
  methods: {
    checkForm: function(e) {
      if (this.newUser.firstName && this.newUser.lastName){
        return true;
      }

      this.error = [];

      if (!this.newUser.firstName) {
        this.error.push('Требуется указать имя.')
      }
      if (!this.newUser.lastName) {
        this.errors.push('Требуется указать фамилию.');
      }

      e.preventDefault();
    },
     
    getAllUsers(){
      axios.get("http://localhost:8080/api/employees")
      .then(function(response){
        if(response.data.error){
          app.errorMsg = response.data.message;
        }
        else{
          app.users = response.data;
        }
      })
    },
    getAllCountries(){
      axios.get("http://localhost:8080/api/countries")
      .then(function(response){
        if(response.data.error){
          app.errorMsg = response.data.message;
        }
        else{          
          app.countries = response.data;
          console.log(app.countries);
        }
      })
    },
    getCities(){
      var id = app.countries.filter(obj => 
        obj.name == app.newUser.country)[0].id;
        console.log(id)        
      axios.get(`http://localhost:8080/api/cities/${id}`)
      .then(function(response){
        if(response.data.error){
          app.errorMsg = response.data.message;
        }
        else{          
          app.cities = response.data;          
          console.log(app.cities);
        }
      })
    },
    getCities2(){
      var id = app.countries.filter(obj => 
        obj.name == app.currentUser.country)[0].id;
        console.log(id)        
      axios.get(`http://localhost:8080/api/cities/${id}`)
      .then(function(response){
        if(response.data.error){
          app.errorMsg = response.data.message;
        }
        else{          
          app.cities = response.data;          
          console.log(app.cities);
        }
      })
    },
    addUser(){
      axios.post("http://localhost:8080/api/add", app.newUser)
      .then(function(response){
         if(response.data != 'Employee added successfully!'){
           app.errorMsg = response.data;
         }
         else{
           app.successMsg = response.data;
           app.getAllUsers();
         }
         app.cleanForm();
      })
    },
    updateUser(){
       console.log(app.currentUser)
      axios.put("http://localhost:8080/api/update", app.currentUser )
       .then(function(response){
        app.currentUser = {};
        if(response.data != "Employee updated successfully!"){
          app.errorMsg = response.data.message;
        }
        else{
          app.successMsg = response.data;
          app.getAllUsers();
        }
      })
    },
    deleteUser(){
      var id = app.currentUser.id
      axios.delete(`http://localhost:8080/api/delete/${id}`)
      .then(function(response){
        app.currentUser = {};
        console.log(response.data)
        if(response.data != "employee removed!"){
          app.errorMsg = response.data.error;
        }
        else{
          app.successMsg = response.data;
          app.getAllUsers();
        }
      })
    },
    selectUser(user){
      app.currentUser = user;
    },
    cleanForm(){
      app.newUser = {firstName:"", lastName:"", patronymic:"", email:"", phoneNum:"", country:"", city:"" };
    },
    clearMsg(){
      app.errorMsg = "";
      app.successMsg = "";
    }
  }
})