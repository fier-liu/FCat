package com.xfdmao.fcat.user.service.impl;

import com.xfdmao.fcat.user.service.MailSendService;

/**
 * Created by cissalcliu on 2017/11/7.
 * welcome to www.xfdmao.com
 */

public class MailSendServiceImpl implements MailSendService {
  /*  private Logger log = Logger.getLogger(MailSendBiz.class);
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private BtcLogService btcLogService;
    @Autowired
    private EmailReceiveService emailReceiveService;
    @Autowired
    private SpecBtcService specBtcService;

    @Autowired
    protected TemplateEngine thymeleaf;
    private static final String from = "coin-notice@eggsdevil.top";//1195718067@qq.com      coin-notice@eggsdevil.top

    private static final String subject = "";


    public  void sendSimpleMail(String desc) throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(emailReceiveService.getEmails());
        message.setSubject(subject);
        message.setText(desc);

        mailSender.send(message);
    }

    public void sendMail(New new1)  {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(emailReceiveService.getEmails());
            helper.setSubject( new1.getSource()+"——"+new1.getName() );

            Map<String,Object> map = new HashMap<>();
            map.put("new1",new1);
            String text = templateService.getTemplateText("new",map);
            helper.setText(text, true);

            mailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sendMail(Btc btc)  {
        BtcLog btcLog = new BtcLog();
        BeanUtils.copyProperties(btc,btcLog);
        btcLogService.save(btcLog);
        int count=0;
        if(!StringUtils.join(specBtcService.getCodes()).toLowerCase().contains(btc.getCode().toLowerCase())){
            count =100;
        }

        while(count++<3){
            try{
                MimeMessage mimeMessage = mailSender.createMimeMessage();

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(from);
                helper.setTo(emailReceiveService.getEmails());
                helper.setSubject(subject+"("+btc.getName()+"-"+btc.getCode()+")—"+btc.getSendReason());

                Map<String,Object> map = new HashMap<>();
                map.put("btc",btc);
                String text = templateService.getTemplateText("template",map);
                helper.setText(text, true);

                mailSender.send(mimeMessage);
                break;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void sendMail(Alarm alarm) {
        int count=0;
        if(!StringUtils.join(specBtcService.getCodes()).toLowerCase().contains(alarm.getCode().toLowerCase())){
            count =100;
        }
        while(count++<3 && alarm.getPrice()!=0){
            try{
                MimeMessage mimeMessage = mailSender.createMimeMessage();

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(from);
                helper.setTo(emailReceiveService.getEmails());
                helper.setSubject(subject+"("+alarm.getCodeSource()+")—"+alarm.getType());

                Map<String,Object> map = new HashMap<>();
                map.put("alarm",alarm);
                String text = templateService.getTemplateText("alarm",map);
                helper.setText(text, true);

                mailSender.send(mimeMessage);
                break;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }*/
}
