class Entity{
    url = "http://localhost:9000/api/";

    constructor(endpoint){
        this.endpoint = endpoint;
    }

    insert(object){
        return new Promise((fullfill, reject) => fetch(this.url + this.endpoint, {
            body: JSON.stringify(object),
            headers: {"Content-Type": "application/json"},
            method: "POST",
            mode: "cors",
        }).then(response => response.json().then(response.ok ? fullfill: reject, reject), reject));
    }

    findAll(){
        return new Promise((fullfill, reject) => fetch(this.url + this.endpoint, {
            headers: {"Content-Type": "application/json"},
            method: "GET",
            mode: "cors",
        }).then(response => response.json().then(response.ok ? fullfill: reject, reject), reject));
    }

    findByID(id){
        return new Promise((fullfill, reject) => fetch(this.url + this.endpoint + id, {
            headers: {"Content-Type": "application/json"},
            method: "GET",
            mode: "cors",
        }).then(response => response.json().then(response.ok ? fullfill: reject, reject), reject));
    }

    update(object){
        return new Promise((fullfill, reject) => fetch(this.url + this.endpoint, {
            
            headers: {"Content-Type": "application/json"},
            method: "PUT",
            mode: "cors",
        }).then(response => response.json().then(response.ok ? fullfill: reject, reject), reject));
    }

    deleteByID(id){
        return new Promise((fullfill, reject) => fetch(this.url + this.endpoint + id, {
            headers: {"Content-Type": "application/json"},
            method: "DELETE",
            mode: "cors",
        }).then(response => response.json().then(response.ok ? fullfill: reject, reject), reject));
    }

}