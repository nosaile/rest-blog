export default function PostIndex(props) {
    return `
        <header xmlns="http://www.w3.org/1999/html">
            <h1>Posts Page</h1>
        </header>
        <main>
        <div id="form-container" class="newpostcontainer" >
        <h1>New Post</h1>
            <form id="submit-form">
        <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Title</label>
  <input type="text" id="create-post-title" class="form-control" placeholder="Title">
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Content</label>
  <textarea placeholder="Content" id="create-post-content" class="form-control"></textarea>
</div>
            <button style="background-color: seagreen; color: WHITE" id="submit-post">submit</button>
            </form>
</div>
<hr>
            
  ${props.posts.map(post => `<div class="card-header"><div id="posts-container">
            <div class="card text-dark bg-light mb-3" style="max-width: 18rem;"><div><h3 id="post-title">${post.title}</h3></div>
  <div class="card-body">
    <p class="card-text"><p id="post-content">${post.content}</p></p>
  </div>
           <div class="d-grid gap-2 d-md-block">
  <button class="btn btn-success" type="button" id="edit-post" data-id="${post.id}" data-title="${post.title}" data-content="${post.content}">edit</button>
  <button class="btn btn-danger" type="button" id="delete-post" data-id="${post.id}" data-title="${post.title}" data-content="${post.content}">delete</button>
</div>
</div>
</div>  
 </div>
            `).join('')} 
            
        </main>
    `;
}

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