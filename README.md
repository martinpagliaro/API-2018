# API-2018
Trabajo Práctico Aplicaciones Interactivas 2018

Sistema de Gestión para Regalos

El equipo de analistas ha finalizado el relevamiento y cotización de un sistema que gestiona listas de regalos.
El sistema debe permitir a un administrador:

Generar una lista de regalos para un agasajado.
Agregar participantes a las listas de regalos
Definir para la lista de regalos: monto a recaudar, fecha de inicio, fecha de fin.

Tanto el administrador como los participantes tendrán un usuario y contraseña para acceder al sistema.

Se solicita al equipo de diseñadores que diseñe e implemente el sistema relevado. A continuación se detalla el relevamiento llevado a cabo por el equipo.

Listas:
El sistema debe permitir la administración de listas de regalos (alta, baja y modificación). De los mismos se debe guardar la siguiente información: nombre agasajado, fecha del agasajo, participantes, monto a recaudar por cada participante, monto recaudado, fecha inicio lista, fecha fin de la lista, estado, mail.
Cada vez que un participante realiza su pago a la lista el sistema debe indicar esa información actualizando el estado del participante y el monto recaudado.
Una vez que la lista llego a su fecha de fin, el monto recaudado estará disponible para que el agasajado pueda disponer del mismo. Se le notificara por mail con un mensaje y la lista de participantes que aportaron al regalo.
Los participantes pueden darse de baja de las listas cuando deseen.
Solo los administradores pueden incorporar participantes a las listas.

Usuarios:
El sistema debe permitir la administración de los usuarios (alta, baja y modificación). De los mismos se debe guardar: nombre, fecha nacimiento, mail.
Los usuarios pueden ser participantes de listas de regalos o administradores.

Pagos:
El sistema debe permitir administrar interfases con las distintas entidades con las que se realicen acuerdos comerciales para realizar los pagos.
El sistema recibirá la notificación del pago realizado por la entidad y lo registrara en la lista correspondiente. La interfaz debe informar el código de la lista, y el código del participante que realizo el pago junto con la fecha del movimiento.

Mail automáticos:
El sistema debe permitir el envío de distintos mails automáticos:
Inicio de una lista a los participantes
Aviso de próximo cierre de una lista a los participantes que no hayan realizado el pago.
Aviso de regalo al destinatario.

Aplicación Mobile:
Se desea implementar las interfases necesarias para interactuar con una versión Mobile que permita a cada participante recibir notificaciones de las listas en las que está involucrado.
