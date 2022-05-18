export default function PostIndex(props) {
    return `
        <header xmlns="http://www.w3.org/1999/html">
            <h1>Posts Page</h1>
        </header>
        <main>
            <div id="posts-container">
                ${props.posts.map(post => `<div><h3 id="post-title">${post.title}</h3>
<p id="post-content">${post.content}</p>
<button style="background-color: cornflowerblue; color: WHITE" id="edit-post" data-id="${post.id}" data-title="${post.title}" data-content="${post.content}">edit</button>
<button style="background-color: orangered; color: WHITE" id="delete-post" data-id="${post.id}" data-title="${post.title}" data-content="${post.content}">delete</button>
</div>`).join('')}   
            </div>
            <hr>
            <div id="form-container">
            <h1>New Post</h1>
            <form id="submit-form">
            <input type="text" id="create-post-title" placeholder="Title">
            <br>
            <textarea placeholder="Content" id="create-post-content"></textarea>
            <button style="background-color: green; color: WHITE" id="submit-post">submit</button>
            </form>
</div>
        </main>
    `;
}


// PostsEvent();

export function PostsEvent() {
    postEventListener();
    putEventListener();
    deleteEventListener();
}


function postEventListener() {
    $(document).on("click", '#submit-post', function () {
        let postTitle = $('#create-post-title').val()
        let postContent = $('#create-post-content').val();
        let newPost = {
            id: 4,
            title: postTitle,
            content: postContent
        }
        console.log(newPost + " was created as a post.")
        fetch("api/posts/", {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newPost)
        }).then(res => {
            console.log("Request complete! response:", res);
            // createView("/posts")
        });
    })
}

function putEventListener() {
    $(document).on("click", '#edit-post', function () {
        let postTitle = this.dataset.title;
        let postContent = this.dataset.content;
        let postId = this.dataset.id;
        console.log(postId + " is the id of the edited post.")
        let newEdit = {
            id: postId,
            title: postTitle,
            content: postContent

        }
        fetch("http://localhost:8080/api/posts/" + postId, {
            method: "PUT",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newEdit)
        }).then(res => {
            console.log("Edit successful! response:", res);
            console.log(newEdit)
        });

    })
}

function deleteEventListener() {
    $(document).on("click", '#delete-post', function () {
        let postTitle = this.dataset.title;
        let postContent = this.dataset.content;
        let postId = this.dataset.id;
        console.log(postId + " is the id of the deleted post.")
        let newDelete = {
            id: postId,
            title: postTitle,
            content: postContent

        }


        fetch("http://localhost:8080/api/posts/" + postId, {
            method: "DELETE",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newDelete)
        }).then(res => {
            console.log("Edit successful! response:", res);
            console.log(newDelete)
        });
    })
};