<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<div> <h1> To Do List </h1> </div>
		<hr>
		<div><h3> Name: ${name} </h3></div>
		<table class="table">
		<thead>
        					<tr>
        						<th>id</th>
        						<th>Name</th>
        						<th>Description</th>
        						<th>Target Date</th>
        						<th>Is Done</th>
        						<th>Action</th>
        						<th>Action</th>
        					</tr>
        </thead>
            <tbody>
                  <c:forEach items="${todos}" var="todo">
                      <tr>
                         <td>${todo.id}</td>
                         <td>${todo.username}</td>
                         <td>${todo.description}</td>
                         <td>${todo.date}</td>
                         <td>${todo.done}</td>
                        <td> <a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                        <td> <a href="/update-todo?id=${todo.id}" class="btn btn-primary">Update</a></td>
                      </tr>
                  </c:forEach>
            </tbody>
		</table>
		<div class="container">
		    <a href="/add-todo-list" class="btn btn-success">Add</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>
