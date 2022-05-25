export default function Navbar(props) {
    return `
<!--        <nav class="nav">-->
<!--            <a href="/" data-link>Home</a>-->
<!--            <a href="/posts" data-link>Posts</a>-->
<!--            <a href="/about" data-link>About</a>-->
<!--            <a href="/login" data-link>Login</a>-->
<!--            <a href="/register" data-link>Register</a>-->
<!--            <a href="/profile" data-link>Profile</a>-->
<!--        </nav>-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/" data-link>Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/posts" data-link>Posts</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/about" data-link>About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/login" data-link>Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/register" data-link>Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/profile" data-link>Profile</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
    `;
}