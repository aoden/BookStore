<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../head.jsp"></jsp:include>
<body>
<jsp:include page="../nav.jsp"></jsp:include>
<!-- Page Content -->
<div class="container">

  <div class="row">

    <div class="col-md-3">
      <p class="lead">Online Bookstore</p>
    </div>
    <div class="col-md-9">
      <form method="post" action="add_product" enctype="multipart/form-data">
        <p><label for="name">Name: </label></p>

        <p>
          <input name="name" id="name">
        </p>

        <p><label for="price">Price: </label></p>

        <p>
          <input name="price" id="price">
        </p>

        <p><label for="des">Description: </label></p>

        <p>
          <textarea class="text-primary" id="des" name="description"></textarea>
        </p>

        <p><label for="isbn">ISBN: </label></p>

        <p>
          <input name="isbn" id="isbn">
        </p>

        <p><label for="author">Author: </label></p>

        <p>
          <input name="author" id="author">
        </p>

        <p><label for="image">Image: </label></p>

        <p>
          <input name="file" id="image" type="file">
        </p>
        <p><input type="submit" value="Submit" class="btn btn-primary"></p>
      </form>

    </div>
  </div>

</div>
<!-- /.container -->

<div class="container">

  <hr>

  <!-- Footer -->
  <footer>
    <div class="row">
      <div class="col-lg-12">
        <p>Copyright &copy; Your Website 2014</p>
      </div>
    </div>
  </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>
