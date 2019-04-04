#!/usr/bin/env python
# coding: utf-8




import smtplib
import os
from email.message import EmailMessage




EMAIL_ADDRESS = os.getenv('EMAIL_ADD')
EMAIL_PASSWORD = os.getenv('EMAIL_PASS')





msg = EmailMessage()
msg['Subject'] = 'test2'
msg['From'] = EMAIL_ADDRESS
msg['To'] = EMAIL_ADDRESS
msg.set_content('test test test')





with smtplib.SMTP_SSL('smtp.gmail.com', 465) as smtp:
#with smtplib.SMTP('localhost', 1025) as smtp:
    smtp.login(EMAIL_ADDRESS, EMAIL_PASSWORD)
    
    smtp.send_message(msg)







