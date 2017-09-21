<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de ProspeXão</title>
        <!-- Bootstrap core CSS -->
        <link href="webjars/bootstrap/4.0.0-alpha.6/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-6 col-xs-offset-3 col-sm-4 col-sm-offset-0">
                    <form name="login" action="/iipweb/acao_usuario?parametro=login" method="post" class="form-signin">
                        <h2 class="form-signin-heading">Autenticação</h2>
                        <label>E-mail</label><br>
                        <input type="email" name="email" placeholder="endereço de e-mail" class="form-control" id="inputEmail" required autofocus value="">
                        <label>Senha</label><br>
                        <input type="password" name="senha" placeholder="senha" class="form-control" id="inputPassword" required>
                        <input type="submit" name="enviar" value="Entrar" class="btn btn-lg btn-primary btn-block">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
