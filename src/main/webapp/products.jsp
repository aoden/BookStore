<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="js/jquery.js"></script>
<script>
    $(document).ready(function() {

        $(".cart-btn").click(function() {
            $.ajax({

                url:'add_to_cart',
                data: 'id=' + $(this).attr('data-id'),
                success: function() {
                    alert("Item added!")
                }
            })
        })
    })
</script>
<div class="input-group">
    <form method="get" action="search">
      <span class="input-group-btn">
         <button class="btn btn-default" type="submit" >Go!</button>
      </span>
    <input name="key" type="text" class="form-control" placeholder="Search by name...">
    </form>
</div><!-- /input-group -->
<div class="row" style="margin-top: 2em">
<c:forEach items="${products}" var="i">

    <div class="col-sm-4 col-lg-4 col-md-4">
        <div class="thumbnail">
            <img src="image?id=${i.id}" style="width: 320px;height: 200px">

            <div class="caption">
                <h4 class="pull-right price"><c:out value="${i.unitPrice}"></c:out></h4>
                <h4><a href="#"><c:out value="${i.name}"></c:out></a></h4>
                <p class="descriptions"><c:out value="${i.description}"></c:out></p>
            </div>
            <div class="btn btn-primary cart-btn" data-id="${i.id}" style="margin-left: 5px">
                Add to Cart
            </div>
        </div>
    </div>
</c:forEach>

</div>