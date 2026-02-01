function doRegister() {
    const email = document.querySelector("#Email").value;
    const name = document.querySelector("#Name").value;
    const password = document.querySelector("#Password").value;


    const user = {
        email, name, password
    };
    console.log('User Object is ', user);
    const url = "/register";
    const promise = fetch(url, {
        method: 'POST', body: JSON.stringify(user),
        headers: {
            "Content-Type": "application/json",
        }
    });
    promise.then(response => {
        response.text().then(data => {
            console.log("data from serve is", data);
            document.querySelector('#output').innerText = data;
        }).catch(err => {
            console.log('data error is ', err)
        })



    }).catch(err => {
        console.log(err);

    })



    // promise.then(data=>{
    //     console.log(data);
    // })
    // .catch(err => {
    //     console.log(err);
    // })
    // console.log(name);

}


function doLogin(){
    const email = document.getElementById('Email').value;
    const password = document.getElementById('Password').value;

    const user = {
        email,password
    };

    console.log(user);
    const url="/login";

    const promise = fetch(url,
        {method:"POST",
         body:JSON.stringify(user),
         headers:{"Content-Type":"application/json"},

        }
    );

    promise.then(response=>{
        response.text().then(data=>{
            console.log("data from the server is ",data);
            document.getElementById('output').innerText=data;

        
        
        }).catch(err=>{
            console.log(err);

        })

    }).catch(err=>{
        console.log(err);

    })
}