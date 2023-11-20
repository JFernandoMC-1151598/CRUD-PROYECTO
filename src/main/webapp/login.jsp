<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script src="https://cdn.tailwindcss.com"></script>
    <script>
        tailwind.config = {
          theme: {
            extend: {
              colors: {
                clifford: '#da373d',
              }
            }
          }
        }
        
      </script>
      <style type="text/tailwindcss">
        @layer utilities {
          .content-auto {
            content-visibility: auto;
          }
        }
      </style>
      <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
</head>
<body>
 <div class="container mx-auto">

    <div class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
        <h1 class="text-3xl font-semibold text-gray-800 mt-5 mb-8">Crear Usuario</h1>
        <div class="w-full max-w-md">
            <form action="UsuarioServlet" class="bg-white shadow-lg rounded px-8 pt-6 pb-8 mb-4"
                  method="POST">
                <div class="mb-4">
                    <!-- hidden input for id -->
                    <input type="hidden" name="id" value="${user ne null ? user.id : ''}"/>

                    <!-- hidden input for action -->
                    <input type="hidden" name="action" value="${user ne null ? 'update' : 'create'}"/>

                    <label class="block text-gray-700 font-bold mb-2" for="nombre">
                        Nombre
                    </label>
                    <input
                            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                            id="nombre"
                            type="text"
                            placeholder="John Doe"
                            name="nombre"
                        value='${usuario.nombre}'
                    />
                </div>
                <div class="mb-4">
                    <label class="block text-gray-700 font-bold mb-2" for="email">
                        Email
                    </label>
                    <input
                            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                            id="email"
                            type="text"
                            placeholder="johndoe@example.com"
                            name="email"
                         value='${usuario.email}'
                    />
                </div>
                <div class="mb-4">
                    <label class="block text-gray-700 font-bold mb-2" for="pais">
                        Ciudad
                    </label>
                    <select id="pais" name="pais" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                        <option>Elige Ciudad</option>
                        <c:forEach items="${CountryList.getAllCountries()}" var="pais">
                            <option value="${pais}"> Cucuta</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="flex items-center justify-between">
                    <button
                            onclick={window.location.href = "list.jsp"}
                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    type="submit"
                    > Guardar </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>