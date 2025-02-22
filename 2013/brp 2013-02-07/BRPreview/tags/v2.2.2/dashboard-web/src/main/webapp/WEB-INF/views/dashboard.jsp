<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="nl"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="nl"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="nl"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="nl"> <!--<![endif]-->

<c:choose>
    <c:when test="${pageContext.request.secure}==true">
        <c:set var="baseUrl" value="${pageContext.request.scheme}://${pageContext.request.serverName}" />
    </c:when>
    <c:otherwise>
        <c:set var="baseUrl" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.localPort}" />
    </c:otherwise>
</c:choose>
<c:set var="contextRoot" value="${baseUrl}${pageContext.request.contextPath}" />
<c:choose>
    <c:when test="${partij!=null && !empty partij}">
        <c:set var="berichtenUrl" value="${baseUrl}${properties.berichten_context}${properties.berichten_service_uri}/partij/${partij}" />
    </c:when>
    <c:otherwise>
        <c:set var="berichtenUrl" value="${baseUrl}${properties.berichten_context}${properties.berichten_service_uri}" />    
    </c:otherwise>
</c:choose>
<head>
	<meta charset="utf-8" />
	<title><fmt:message key="application.title"/></title>
	<meta name="description" content="">
	
	<!-- Use the .htaccess and remove these lines to avoid edge case issues. More info: h5bp.com/i/378 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <link href="${contextRoot}/resources/css/html5reset.css" rel="stylesheet" type="text/css" />
	<link href="${contextRoot}/resources/css/dashboard.css" rel="stylesheet" type="text/css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="${contextRoot}/resources/js/libs/jquery-1.7.2.min.js"><\/script>')</script>
	<!-- All JavaScript at the bottom, except this Modernizr build.
       Modernizr enables HTML5 elements & feature detects for optimal performance.
       Create your own custom Modernizr build: www.modernizr.com/download/ -->
	<script src="${contextRoot}/resources/js/libs/modernizr-2.5.3.min.js"></script>
	<script src="${contextRoot}/resources/js/libs/jquery.timeago.js" type="text/javascript"></script>
    <script src="${contextRoot}/resources/js/libs/jquery.timeago.nl.js" type="text/javascript"></script>
    <script src="${contextRoot}/resources/js/libs/jquery.autoellipsis-1.0.8.min.js" type="text/javascript"></script>

	<script>
	//Page fadein
	$(document).ready(function() {
        $("body").css("display", "none");
        $("body").fadeIn(2000);
    });
			var console=console||{"log":function(){}};
            var lastCall = new Date();
            var aantalBerichtenOpHetScherm = 0;
            var maxAantalBerichtenTonen = 7; //default, wordt overschreven door de waarde zoals die door de berichten wordt doorgegeven

   
		    function getNewMessages() {		    	
		    	var urlMessagesSince;
		    	
		    	urlMessagesSince = "${berichtenUrl}/" + lastCall.getTime();
		    	console.log("URL berichten sinds: " + urlMessagesSince);
		    	//urlMessagesSince = "${berichtenUrl}/";
		    	var newMessages = $.ajax ({
                     url: urlMessagesSince,
                     dataType: 'json',
                     timeout: 10000,
                     success: function(data) {
                        if (!data.berichten){
                            console.log('Geen berichten in JSON resultaat gevonden');
                            return false;
                        }
                        console.log('Berichten opvragen sinds ' + lastCall.getHours() + ':' + lastCall.getMinutes() + ':' +lastCall.getSeconds() +', parameter:' +lastCall.getTime());
                        if(data.aantalBerichten > 0) {
                        	console.log('Aantal berichten:' + data.aantalBerichten);
                        	maxAantalBerichtenTonen = data.maximumAantalBerichtenPerPagina;
                        	//maxAantalBerichtenTonen = 4;
                            for( var i in data.berichten.reverse()) {
                            	var result = data.berichten[i];
                                $res = createMessage(result);
                                if($res == null) {
                                	continue;
                                }
                                if(result.prevalidatie == true && result.aantalMeldingen == 0) {
                                    console.log('Skip succesvolle prevalidatie. Bericht van ' + result.partij + ', tekst: ' + result.bericht);
                                	continue; //Skip de prevalidatie zonder meldingen
                                }
                               
                                console.log('bericht ' + i);
                                console.log(data.berichten[i]);
								var lastMessage = $('#messages article:last');
								var total = $(".bericht").length;
								//$('#messages article:last').slideUp();
                                aantalBerichtenOpHetScherm++;
                                if (total > maxAantalBerichtenTonen-1) {
										lastMessage.fadeOut(1000, function() {
										lastMessage.remove();
										showNewMessage($res);
									});
                               	    aantalBerichtenOpHetScherm--;
                                } else {
									showNewMessage($res)
								}
                            }
                            lastCall = new Date();
                        }
                      //humanitize timestamps
                        jQuery("span.timestamp").timeago();
                         var options = {
                        		 ellipsis: '...', setTitle:'always', live:false};
                         
                        $('.bericht').ellipsis('.berichttekst', options);

                     }
	                });
	            }

			function showNewMessage(msg) {
				if(msg != null) {
					msg.hide();
					$("#messages").prepend(msg);
					msg.slideDown(1000);	
					jQuery("span.timestamp").timeago();
			    }
			}
				
		    
		    function getAllMessages() {
                console.log("URL berichten" + "${berichtenUrl}");

		    	$.ajax ({
					 url: "${berichtenUrl}",
					 dataType: 'json',
					 timeout: 10000,
					 success: function(data) {
						if (!data.berichten){
							console.log('Geen berichten in JSON resultaat gevonden');
							return false;
						}

						console.log('Berichten ' + data.aantalBerichten)
						maxAantalBerichtenTonen = data.maximumAantalBerichtenPerPagina;
						for( var i  in data.berichten) {
							if($(".bericht").size() >= data.maximumAantalBerichtenPerPagina) {
								console.log('Maximum aantal berichten voor het scherm (' + data.maximumAantalBerichtenPerPagina + ') bereikt. ' + i);
								break;
					        }
	
							var result = data.berichten[i];
	                        $res = createMessage(result);
	                        
	                        if($res != null) {
	                            //voeg het bericht toe
								if(result.prevalidatie == true && result.aantalMeldingen == 0) {
                                    console.log('Skip succesvolle prevalidatie. Bericht van ' + result.partij + ', tekst: ' + result.bericht);
									continue; //Skip de prevalidatie zonder meldingen
								}
									   
								console.log('bericht ' + i);
								console.log(data.berichten[i]);
								$res.hide();
								$res.appendTo($('#messages'));
								$res.slideDown(1000);
								aantalBerichtenOpHetScherm++;
	                        }
							//humanitize timestamps
							jQuery("span.timestamp").timeago();

							//cleanup
							while ($(".bericht").size() > maxAantalBerichtenTonen) {
                                       $('#messages article:last').remove();
                                        aantalBerichtenOpHetScherm--;
                            }
						}
									
						lastCall = new Date();
                        $('.berichttekst').ellipsis();

					 }
				});
			}
				
		    
		    function createMessage(message) { 	
		    	var bestaandId = "bericht-"+message.berichtId;
		    	
		    	if($("#"+bestaandId).length != 0) {
		    		console.log("Skip bericht " + bestaandId + ", deze bestaat al op het scherm");
		    		return null;
		    	} 
		    	
		    	var articleElem = '<article id="bericht-' + message.berichtId + '" class="bericht" />';
		    	var $res = $(articleElem);                        
                $res.empty();
                
                var timestamp = new Date(message.verzondenOp);
                
                var content='<div class="padding-fix">';
                
                content += '<figure class="berichtIndicatorLinks"><img src="${contextRoot}/resources/images/' + message.partij + '.jpg" class="stadlogo" title="' + message.partij + '"></figure>';
               
                var messageClasses = 'berichttekst';
                if(message.aantalMeldingen > 0) {
                    messageClasses += ' meldingenAanwezig';
                }

                content +='<div class="'+messageClasses + '">';
                content +='<span class="timestamp" title="' + timestamp.toJSON() + '" >' + timestamp.getDate() + '-' + timestamp.getMonth() + '-' + timestamp.getFullYear() + '&nbsp;' + timestamp.getHours() + ':' + timestamp.getMinutes() + ':' + timestamp.getSeconds() + '</span>';
                content +='<span class="stadnaam">' + message.partij + '</span>&nbsp;via&nbsp;<span class="bzmnaam">' + message.burgerZakenModule + '</span>';
                
                if(message.prevalidatie == true) {
                    content += '<figure class="prevalidatie"><img src="${contextRoot}/resources/images/prevalidatie.png" class="prevalidatie" title="prevalidatie"></figure>';
                }
                
                //Icoontjes die de status van de meldingen aangeven
                 if(message.aantalMeldingen > 0) {
                	 if(message.prevalidatie == false && message.berichtDetails.indexOf('Fout') == -1 && message.berichtDetails.indexOf('Overrulebaar')==-1) {
                         content += '<figure class="melding"><img src="${contextRoot}/resources/images/meldingen-ok.png" class="meldingstatus" title="Bericht verwerkt met meldingen"></figure>'; 
                     }
                
                     if(message.berichtDetails.indexOf('Waarschuwing') >= 0) {
                         content += '<figure class="melding"><img src="${contextRoot}/resources/images/meldingen-waarschuwing.png" class="meldingstatus" title="melding(en) met waarschuwingen"></figure>';                        
                     }
                     if(message.berichtDetails.indexOf('Overruled') >= 0) {
                         content += '<figure class="melding"><img src="${contextRoot}/resources/images/meldingen-overruled.png" class="meldingstatus" title="melding(en) overruled"></figure>';
                     }
                     if(message.berichtDetails.indexOf('Overrulebaar') >= 0) {
                         content += '<figure class="melding"><img src="${contextRoot}/resources/images/meldingen-overrulebaar.png" class="meldingstatus" title="melding(en) overrulebaar"></figure>';
                     }

                     if(message.berichtDetails.indexOf('Fout') >= 0) {
                         content += '<figure class="melding"><img src="${contextRoot}/resources/images/meldingen-fout.png" class="meldingstatus" title="melding(en) met fouten"></figure>';
                     }
                     
                     
                 } else {
                	 content += '<figure class="melding"><img src="${contextRoot}/resources/images/meldingen-ok.png" class="meldingstatus" title="Succesvol verwerkt bericht"></figure>';                      
                 }
                
                content +='<p class="message">';
                

                content += message.bericht;
                details = message.berichtDetails.replace(/\n/g, '<br>');
                content += '<br>' + details;
                content += '</p>';
                content +='</div>';
                content += '<figure class="berichtIndicatorRechts"><img src="${contextRoot}/resources/images/' + message.soortBijhouding.toLowerCase() + '.jpg" class="berichttype" title="' + message.soortBijhouding + '"></figure>';

                
                content +='<div class="clear"></div></div>';
                
                $res.append(content);
                
                return $res;
		    }
				 
			getAllMessages(); 
			$('#message-container').show();
			setInterval(function(){ getNewMessages ()}, 10000);  
			

		
			
			
			</script>
</head>
<body>
	<header><hgroup><h1><fmt:message key="application.title"/></h1></hgroup></header>
	
	<div id="wrapper" role="main">
	   
		<section id="message-container">
			
				<div id="messages" class="notification-area">
				</div>
		</section>
		<div class="legenda">
        <figure class="melding"><img src="${contextRoot}/resources/images/meldingen-ok.png" class="meldingstatus" title="Succesvol verwerkt bericht">Verwerkt</figure>
        <figure class="melding"><img src="${contextRoot}/resources/images/meldingen-waarschuwing.png" class="meldingstatus" title="melding(en) met waarschuwingen">Waarschuwing</figure>
        <figure class="melding"><img src="${contextRoot}/resources/images/meldingen-fout.png" class="meldingstatus" title="melding(en) met fouten">Fout</figure>
        <figure class="melding"><img src="${contextRoot}/resources/images/meldingen-overrulebaar.png" class="meldingstatus" title="melding(en) overrulebaar">Overrulebaar</figure>
        <figure class="melding"><img src="${contextRoot}/resources/images/meldingen-overruled.png" class="meldingstatus" title="melding(en) overruled">Overruled</figure>
        <figure class="melding"><img src="${contextRoot}/resources/images/prevalidatie.png" class="meldingstatus" title="Prevalidatie">Prevalidatie</figure>  
        <br>
        </div>
      
 	</div>
   <footer id="footer">
    <div id="footerline"><p><img src="${contextRoot}/resources/images/rijksoverheid-logo.jpg" height="25px"/>&copy;2012&nbsp;Versie&nbsp;<fmt:message key="application.version"/></p></div>
    </footer>
	

</body>
</html>	