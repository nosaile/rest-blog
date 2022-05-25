export default function User(props) {
    return `
        <header xmlns="http://www.w3.org/1999/html">
            <h1>User Profile</h1>
        </header>
        <main>
            <div id="user-profile-container">
            <div>
            <h4 id="profile-username" data-username="${props.user.username}">${props.user.username}</h4>
            <h4 id="profile-email" data-email="${props.user.email}">${props.user.email}</h4>
            <p id="profile-password" data-password="${props.user.password}" type="password">${props.user.password}</p>
            <button style="background-color: cornflowerblue; color: WHITE" id="edit-user-details" data-id="${props.user.id}" data-username="${props.user.username}" data-email="${props.user.email}" data-password="${props.user.password}">edit</button>
            <input id="newPassword" data-id="${props.user.id}" style="display: none" placeholder="new password"><button id="submit-new-password" style="background-color: green ; color: white ; display: none" data-id="${props.user.id}" data-username="${props.user.username}" data-email="${props.user.email}">submit</button>
            <hr>
</div>
           
     
</div>
        </main>
    `;
}

export function ProfileEvents() {
    editPassword()
}

function editPassword() {
    console.log("entered editPassword event")
    $(document).on("click", '#edit-user-details', function () {
        $('#newPassword').show();
        $('#submit-new-password').show();
        $(document).on("click", '#submit-new-password', function () {
            let userPassword = $('#newPassword').val()
            $('#submit-new-password').attr("data-password", userPassword)
            let userUsername = this.dataset.username;
            let userEmail = this.dataset.email;
            let userId = this.dataset.id;
            let newUserDetails = {
                id: userId,
                username: userUsername,
                email: userEmail,
                password: userPassword
            }
            fetch("http://localhost:8080/api/users/" + userId +"/updatePassword?newPassword=" + userPassword, {
                method: "PUT",
                headers: {'Content-Type': 'application/json'},
            }).then(res => {
                console.log("Edit successful! response:", res);
                console.log(newUserDetails)
            });
            $('#newPassword').hide();
            $('#submit-new-password').hide();

        })

    })
}

