/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package booksmart.cashier.frames;

import static booksmart.cashier.frames.BookUpdate.BookImagePath;
import static booksmart.cashier.frames.BookUpdate.CategoryId;
import static booksmart.cashier.frames.BookUpdate.CategoryName;
import static booksmart.cashier.frames.BookUpdate.ageId;
import static booksmart.cashier.frames.BookUpdate.ageName;
import booksmart.connection.connection;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kisha
 */
public class StockUpdate extends javax.swing.JPanel {

    private final HashMap<String, Integer> bookMap;
    private final HashMap<String, Integer> stockMap;

    public StockUpdate() {
        this.bookMap = new HashMap<>();
        this.stockMap = new HashMap<>();

        initComponents();
        loadBooks();
    }

    private void loadBooks() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `books`");
            Vector<String> Books = new Vector();
            Books.add("Select Book");
            bookMap.put("Select Book", 0);
            while (rs.next()) {
                String BookName = rs.getString("Book_Name");
                bookMap.put(BookName, rs.getInt("Book_id"));
                Books.add(BookName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(Books);
            BookComboBox.setModel(dcm);

        } catch (Exception e) {
        }
    }

    private void loadstocks() {

        String selectedBookName = (String) BookComboBox.getSelectedItem();
        int BookId = bookMap.get(selectedBookName);

        try {
            ResultSet rs = connection.Search("SELECT * FROM `stock` WHERE `S_Book_id` = '" + BookId + "'");
            Vector<String> Stocks = new Vector();

            Stocks.add("Select Stock");
            stockMap.put("Select Stock", 0);

            while (rs.next()) {
                String StockNames = "QTY:" + rs.getString("Qty") + " | pri:" + rs.getInt("Public_Price");
                stockMap.put(StockNames, rs.getInt("Stock_ID"));
                Stocks.add(StockNames);
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(Stocks);
            stockComboBox.setModel(dcm);

        } catch (Exception e) {
        }

    }

    private void BookDetailsLoad() {
        String selectedBookName = (String) BookComboBox.getSelectedItem();
        int BookId = bookMap.get(selectedBookName);

        try {
            ResultSet rs = connection.Search("SELECT * FROM `books` "
                    + "INNER JOIN `category` ON `books`.`Category_Category_ID` = `category`.`Category_ID` "
                    + "INNER JOIN `author` ON `books`.`Author_Author_id` = `author`.`Author_id`"
                    + "INNER JOIN `language` ON `books`.`Language_Language_ID` = `language`.`Language_ID` "
                    + "INNER JOIN `recomend_age` ON `books`.`Recomend_Age_R_Age_ID` = `recomend_age`.`R_Age_ID` "
                    + "WHERE `Book_id` = '" + BookId + "'");

            if (rs.next()) {

                BookName.setText(rs.getString("Book_Name"));

                CategoryName = rs.getString("Category_Name");
                CategoryId = rs.getInt("Category_ID");

                Language.setText(rs.getString("Language_Name"));
                Author.setText(rs.getString("Author_Name"));
                Age.setText(rs.getString("Age"));
                category.setText(rs.getString("Category_Name"));
                BookImagePath = rs.getString("Book_img");

                System.out.println(BookImagePath);

                ImageIcon icon = new ImageIcon(getClass().getResource(BookImagePath));

                Image scaledImage = icon.getImage()
                        .getScaledInstance(
                                ShowBookIMG.getWidth(), // Use JLabel's width
                                ShowBookIMG.getHeight(), // Use JLabel's height
                                Image.SCALE_SMOOTH
                        );
                ShowBookIMG.setIcon(new ImageIcon(scaledImage));

            } else {
                System.out.println("Something went wrongüò≠");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Please contact the devoloper",
                    "DBMS error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    private void StockDetailsLoad() {

        String selectedStockName = (String) stockComboBox.getSelectedItem();
        int StockId = stockMap.get(selectedStockName);

        try {

            ResultSet rs = connection.Search("SELECT * FROM `stock` WHERE `Stock_ID` = '" + StockId + "'");

            if (rs.next()) {

                StockQty.setText(rs.getString("Qty"));
                BPrice.setText(rs.getString("Public_Price"));
                SPrice.setText(rs.getString("Original_Price"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please contact the devoloper",
                    "DBMS error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void empty() {

        StockQty.setText("");
        BPrice.setText("");
        SPrice.setText("");
        loadstocks();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BookComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ShowBookIMG = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BookName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Author = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Language = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stockComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        StockQty = new javax.swing.JTextField();
        Age = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BPrice = new javax.swing.JFormattedTextField();
        SPrice = new javax.swing.JFormattedTextField();

        BookComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BookComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Select Book");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Book Name :");

        BookName.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Category");

        Author.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Author");

        Language.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Language");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Age");

        category.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Stocks :");

        stockComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Book To see Item" }));
        stockComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Remaining Stocks Quantity:");

        Age.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Buyed Price :");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Selling Price :");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setForeground(new java.awt.Color(252, 252, 252));
        jButton1.setText("Cancel.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setForeground(new java.awt.Color(4, 4, 4));
        jButton2.setText("Update.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        SPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BookComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ShowBookIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BookName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(category, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Author, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 142, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                            .addComponent(Language)
                                            .addComponent(Age, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stockComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StockQty)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SPrice))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        ÆjtdRrefe:rddCe∞ka~a\.[◊Ì~wmHaykuvWpÒl(Éˇ-romjdPl¡cmmAnt.U\SE|A`eD	& $  (  £"!  `(†a     %,`‰BÁ{ knÓt*BnjkNaml.aKafa8&cwing&Grgup@axnu‰.@ROBEP≈D[SIH≈,!javÒ¯,sÔiNg.Wbnea|`Qo˜t/FG@UÃT^RIMl harah.s{iÓg&GsomxNiyodt.PXeFERRA•_”IHEa
 †!!! `h∞"  ® ! 1 0""`(,a$tGaq(1)p1º, ∞8)
"  09 `a (  `†‡`† 0(°"  ™qddCroup(l·io’t*ar·pdxq&`lAlGz/Urij`v·p&svigÁ&Grou`Ea¯Ì}v>IÃiGn]ehdnRAS≈Kze)
  §0%   ≤ 08,  P ,!  (!  "0$na‡lCkmpol%np jNabeeÙ0`"2 !   $   %, ( ( ∞ 0  † ?eddCip˚l'lT(JN˘Fe@9()†`0!!` $2∞! "   4$(( ! .eddrECapv5‰CqIjkˆcx~Ûwqfg.LiyoupS‘yl√/mq/LmnºPnacÈm%nt.NR«AUUD-
     ( !†  †4  ( ††"  (Ä&addGsO0H)laq/vt.cv%epÂPabal|UlFìmqpjawc¯*swi~g.Úowqli}o%Ù.Elhgnm·nrÆVIS≈LM∆A)ä    †  $  j $    `    " b$ ,a$vC/npo~ij0∏savdfocy®!b`Vax/{Áixg*%rcuqNe˝nat&êR]fEPR¿OSYZE$(zapay,cwmNg.G:|talE{o4t.T≈fUTLtW_i:A<$˙—vax&ci.e/GRkQpÃaykuÙ.ﬁEfERRIDOS„XD)J$`    †)($  ( 8a k a " !0a ,add/,pÔhDlt8AGu,(javy?cwih˜¶GzoqTiqxØutÆPRÖNMvLOCJPA, j)~!x/suin«.'pkurda9w5º™DTvAuŒ]SiZM`*ivo¸.3-i.g.rOuuMes/a|oPRGNERREDW_SRCi)	 (" "0 Ç0 !0 §†!d †( `>adÏ«ap(:2< 2?, ;©J" 00     (   Ä†!% ( 0  .EDdBrnwR(`‡Òkut√re`tePaÚahn%|Gr/ıp*jk&i\._sig.WroQ0È{lï>*Ifi&n-–ÓeÆQS%L…F≈)Ç    0‡ `! (,  ! " 0  "  `.cudBgMojan|(ÍgbaL7)
a0  Ä`  ` $"1 f f 0  ( `"†",·DÂc˜m|«ndjt-jDaFu`8))J  ( !n$`! !$ !q `&0 4 *ÒdlP6geR^df«eP§jafcp∆wwyfaY'tf◊t[$e.m/m^EjVëlmseoefr.ŸBELAtED)P †4 " „ 0 ! (   ("pc†  #Ad‰GrouP`l#}ÔqtcTate@ar·nlfmCroup®*aVeX.sw(fg,GRowt]!Qo˝4,KlK˜j}enFjBISELI^E) 0(   †  †F  ($ ``†™& 9 †$`.addo_nu.|(¡U4(Et(†jc6c¯,s˜ÈfgÆGbkıpayn5u§@“EFURZD_SAEj(n!∂iX,{µine.gpmu0Ã!}o%`.DˆEDTS… E,1*cva}*uw)jG¶WRoÛpNeqnu=QRAVDDœSiZE>"  !8 , "  )   1 8`  (¨  8( .hv$CEpLkelp(LaN'=awu jaV`x.{fiNf&gzwdrL`Ymu|>TR@FMSPU«]QIE, Ía÷`Z.sw˘nc.ObOtpNayou¸.Dm∆AUT]W”KZD<2o°Vay*rwimeGJwu0LaYoutnp2EBDRQEE∑”IZÖµ	 +†   `"¨®(A$    ¢¨†$ $ËÆ%v&@wmfarrddGAx8ja˛aX.q&InM. aynut√dYÏq/√|m`oÔentPÙÂ#eÏen4.FlrElTE©x  8§0( `$0$     ! !†""$b¨addKok0ooe›t(nLDbl,w!ä∞)  0b    $ †(, $"!(*i$drafÂqrabG`‡∏:arax$QwAng.haxntÊS˛yhe.Ckmu/oeN4Xl!ce}·T.U^REL%E) ! $!†0  ` †$Ä  0     `0.TfCEltm,enpsuoÎkComjbo¯¨$javaxnww).G.Or~dPD!ylu\.@EFAZZEQsKZEdMgva8é7wi¬g(G2/u`LaY/qt/TCFAUM_cmA,§Iaviÿ>{gKnc.ORowuDi˘bÂvnGFrRM‰_[âZE)a$m(0$ @% † @ !  ` $$ &.aldPPedÂpreeÁqP(˙max.sıyng.duowıStyne>iomTonejtP¨AcdedlÙnuÓLETEƒ)#( !!   `†`0" *†$   (1 Ô·d‰com¯Ônent(jLa`ul5!
   9    !∞2 (1! @  `  "d.qÂd0Ú≈nosRuTGap8jav!h,s'°n'.a˘ÎytqM|l%Ënmq/Óu>tQŸ·gelund~REåATM≈©
$(†† 9 $!0 †  8 "" ‡g"0Æed‰ÁÁ}@oneÙ®St/cc’4]$$jqfa¸.s˜ÈnÛC:+Q|\aykdÙ.TREFERSeDYsMZen jrˆah.„WInO.F2Ø1pL1yfÂg"ƒa¶auLt[SAXE, k·van.wiËc)EroupLiq)5tn–REFERZEDSARï+`   % ud 0¢Äd $ ( `"0`2.EA@@:eÊgv≤etGqB(*aˆaxSvinÂ.Layo7U”uyld.CÓ°Poz!ÓtPhqganinÙ.[Ö^AtUD! 0!`pp† °"@!∞d "   "  (a(dGrotR(m GmUT>qRıredPsv·mle–Frouf0äaf·R.SvÈ.f.ErowqÌa]oufÆÓiÅnm}ou.TSEIlINá+ † !(   ! (x! † ††&( "$" 0§ :ql‰CR7ı¯0d!kÔe`Ø#rmad%Sm uwnthelRotp(• †$  ††°  (( ¥ ®  !        &0  ∫atdB/mpO>flt8f\bel)
  0      †qb `†2† !`"2‡   4  h  ud&Fap68,0-08))
  ¢!`$$   $`)  (! @2(`    2.·‰tGRouÚhl…Ykt|.kRe!ÙeRequeL5a`hWpv5-h
, † 1:`(â ` †` 0 )    †0`"p(  >elÊBoepÏcfthNhqban9(*"h         ∞ 0   !     ( "   &p .„§t6GgdÚbEdG°`)™a6!8n{7dmG*Ma[Ôqt[tqna>CÔm`ongf|P`¡#eyejp.BELQPED€* 4$)""   00   `   !`(       8 .wd‰ˆ{ur(ÏeΩ/ut>brÑ`duTaRap,elE“Ôw¯®k1wI˙>w˜al'/GV)˜<Laykut.Ilhon©ufp.BA”ED…N)°  "  §  †† (†1    ¯'$§ "0   %    .qd$CgmPojent∏¿prkad/bka~g{&s≥yÏÔ.Grn5ÙLaykUt.PREFERVAƒWQ…ZE, h!f`(~s`A,e?G‡+}pHÒ}ÌuV.DEFa≈NWS»RM< bmˆap.cgh>%
EFœtpaqg5u.PR¡FEWPYQzA(
       $•`(    ` àh" †∞"     ""  "`&.ÏdCmmroneo‰ SR:iki †*avaxcvwiÓg*GgUpLCyktunxRFMREA[cI~w- jcgx,wvI.w"GzeuALeioqtÍLeÊ@TﬂSIöE,"Í(vc¯s˜ingØWnmpDaQOu4~PPDN≈RRED_sJZ@-!#))* † ®$ $$ )0†(!0($ faddEr/qp(l·Y?ud.cveÒxÂSeUÂÂÓı)slC~ot3(-∏p !0 § `§    !     (  "6ahdPrederr%dGAt*ja˛!xÆ{qÈng.^ayÔutCtyf%nGomq'ng.tXlgq3Ìent.U^R’M¡T¿D)å("°``( $$†0†" `( !   bÇ ÓauDKo-pkNEod WhowBooJIIEÏ b·ˆ@xÆ{7)ng&Árt0Lgsouul–R¡FUvGD_SIZM, 4"8`jÕVaX*awijf.„∆n]rLaycRt&P“FEZEL3XBEiç)
"†   (©!    (%(/`TeRreverzd$Gqp(z`~c:nwkneL`koqtStyLe.√ompongotêhQce}%~4,GNRML\EE!
$ †!` † !  &† °8.ÁDdr/tr(,9yg}~,Ûrd≤tepi:aÏdmÏfbÔup(Í·'ix/Ûwi+g.Ro\p`yuthIly'ËmeNt˛PE€GEIN©
 " !   " $pa  ††`  aÏCoMpnent!jU6pn1!  ∞ `) `  8  9(     .etuCoipokent:nBeutOn2)-
`   d  0S 0  ∏ 0/a ÑÀÔnvcmjÂjgi0)22(RzmzdOAXVVÁntE)m$ ' !h†);J  0 yÁ/Èî-Ì‰itØv-vo~d>//G«N5’LT;i|ip[/Mxonenus

 )4!p0ivat% voaÂ`BJÔkc/mbcBo¯¡`|i.-rfgvm%dËjavCavt*eÙe|ˆ*@atijnEvend er|È$=6O%N≠GIíS\8eV&~u_BÌ'+√KmboBcja√tc/n@ÂrnGr]ad 2Âr`!! ¬mÔkE•|cmlÛL*c`h);H& @ d  !|fa&wt˝gKf);J " a˝/©fEN=eQAT>%vej4_BooCcombo¬cxAc4i/~e‚¢orlÂ4
  ( prhˆmt#"~ÎiF0z“u’TØ|—µktamÓ–erfrmet*ade.aw6&Wvd.t=CcdiÓnMvdn\†gTı90;Ø/ON=@…ZAP8mFeLt_zFwÙtk61ACtio&PÂrnGRÌdd
 8 `(   ampli(°{
`   }.ØGEJ=LASeveÓT_jRqtpÔ~!i#kÁ~XeÒfoz}ed
:l † sÚk!t! v=m` ctÎc+Gomcgo|Acdhgjergørledh(AvcÆawrÆEv}j\Æs¥h/f V$nT eft	 k'«gJ%FÀRÛv:mventZs4ÔcKC/bgjOiAgtiØlÂvNœbÌuO §     (WoakTdti{Ï∂\/adh)
    }/Ga--LCSd:5Vent_rToa„ClroBixActi/nDÂ≤.{bm‰ä$ $2prÈ6·tm fomg`jDqtpjnRActignPE#FÌ6mel(h1faj„wp.e6e,U&ÅkdcknÆeltgtt) [ø+GN-V“sU∫ewMztJbepToj2Ecpik:Berfirm`$° $ $0 St2ÿng Òe|ectmdQpU#+Na-e y((CÙÚaÏC( slOcCoÌbÔfo8*g%ÙQÂlactddQ|eM*©;⁄§(    `"ind(ZtOck´d0Ω4qNC»L2,few®qeÃÂcttduncÎNime,õ b  $"¥ $Stri.g wpy <¢S|ggkQ˝˘ngeTîuzt(	tR)Ì()2ä ",   `(StrmnGaBdyP3I√Ì∏=1JPrice.g'tT%xt!+/ırii		≥ `b! "# t1‡lœ!sedQpac` KP˙ÈCuÆgct`jdh(,4vËm))
ä4( !Ä0  If†Ëqwy,{s"lyÍc)) {
† ! ! @    HOpV9onQaÓe.s`ouçesW#feDÈaoogàÓt,(8 ( p  °†Ä  #†· a†∞  $P|Âaae©Unto2`V¯E@Uvoc*	Yty.§
! †a$*`(    $  !  "S¥o‡%"J4` †    £ †    (0  JØ‡PkOlT`lg/MROR^mWs0AFG);ä$†`!4¡†    rÂttvÆ
` ®  4 0Ì 	   †"f
!      "if (bua–2he,)smsjka))`¢ `  (°  `#!JOpdi{n@qnD%s`mwowscge‰aeÏoc(~ulLΩ$"  † ( ¢ 0r ($$ ( "TdeASe En%(t)e)CoÎsjuyUe –rice"%" 4    ® 0   (§ ® P!"SvnSk*(
$$$  )0! +("¢  0   JOpt)onzane,ERROrMESS`E3J   !$  †$¢-0wep’pk:* `$8 t †* `q!` 0 
 0   ))©mg ){!ÌPÚMceèÈ≥K(„nÎ!) {
‚`%0  ††  ` KOpvkO.!ng¶s`wmesw±ÁEF8`lNg∫nwl$,"$$ `  †` (1 r•0 !  .Pn≈ace U~4dr x:ap@ook"SulyiNw2ê0¿Ám†-qd"† ¶$  $  (`($ :"CıoBk". !®
  ·b    h $! (!°JOÒ\io~Pand.ERR/ROmEqCAGM!a    †$ 0(∞ÑvetırÓ#
#` " ¢
†}éJ( " ("  DAteViÈaFOr}At$e^ Fk2})vD}p =8`At‰vlmeDozmldt|6.ÁfPqQ5urm("y}y}-mM-td i™-d:bR"!;* 2†b 0"&3prjng©rormÈtedDatÂTÈee }0lk#al« TuUj-Â.d/˜(9.&oPcit(fÔblftt@r);*
∞  ``) P·mnfA#tioÓ.IUÑ`bUpM≈TE 0{‰okk `”EP"`QtiÙ(5 '( "2q‰}d3"%(<†iPubdos_Pz®ªga 9 c" ";•¨QrH„  *"#+bäh p2  ¢ ",$   (¢+ "¨!∆œviÎ©oa,_Y"hCu` = 'b *†RuYPricm`´*'!j2»NeÛtvo7k^UQfa6ÂB†="Á" +`vÔsÌEt55g‰aTeTymÏ +†b˜†Je“Â0`ótmak]…@b >8''"+ R4okkEÂ!©"'"i;Æ
 )"! !"‚
Irti/f0ave.s8e7MecsaeedealÔk(nU,|,+  !d!   `   0  "quocÀ!x‰q∂%lpqcceÛrfuÓmb, 4 `!$   † " Ä "[toAk ADdd&¨
   µ 0 %%("   $ jGqtio.P·neÆIo&OR√TYCOZiMSSADI;ä%≤Ë  * "gh∞xyi/3
$‰  uo'«UO≠Lƒ[t*gven|]ÍJuttnÓ2Ac$HÔNPEzfØrMÂd

  † '7 Va~)!b,%s dejdis#|io,†" oo$o˝d8mmliÏΩ//GÖN-JEC…Nv·si¡bleyj!!*!prÈtqTe(juv`x.swyjU.ZP≈p4N)aL‰Cgm+
$ &rI6!‰e zctcp'swmFg.JTdytfiejf!Au\,p;™& † pzc~1tm!mavay.3uifg)KF2Mhtta§tÂ¯TFi!me BPviamª ∞( pRiva|E@jÈrqx.sˆifg.*CkmCoR/z8Rp‚mng?¢Ro]bSoÕ¢oBKX:† Ä psk¥aPe#jav!rdsvinW,JUexxFiml`Cog+Nqm%Ô( 0† Pravbtmhev·ÿ?s6kjgJuEpÙÏÙ.!l-CNÁtag%;
ëëp`rzi~etu *ivix.zWYng.Jd0kidt%D¸extWi°lf"SXÚiceª
 `)atr·¶q4E Hcfi8&srijo>ÍIAjul ShmsBÔoKM ¨†$p0i6aueca6ahsgπd'+ZTehtVke(e`Ct?kjSt~7  !"prm$¡di1k‚ˆEx.ÚwÒD˜. FextVmeLd aitgiwy;"(8|piVatuÄj6ah.swiff¨HFMvTnl<jjut‰oNë3N"h` Dsiv"0e(*ava.s˜Mfg.[B}<<Ôg kRutt~≤:0,(xrmdxe"
ƒvq~:÷alg/KÃa"ml jHa"dl10;
`í 8tÚi4aÙe!kafep3winG?BLabe¨@j\abml0°2
† 0(20)dAul ∏`viz.{w)ng.ÃÃAjad0j|A˙en;J¢ (`srâv}te†ja6ax.sskn,JLabÓ jL„heÏ3˚@¢ †pC)vauu ja÷cx.3wing.ZÏa‚M)j·rel0?J"  pySÈvate0kereH;wmn'>jLubgl$bL	jel5;
 : priva|! ¢oˆAX$sg)ng.JDa‚dl jLabe|2;*   "bzinaˆt0na∂apnqwingJLpbÂd¢jLareh7ªJ"(0"pfiˆa4Wleva0/wqinG.H
afelj!"el8;
†®$"ÛÚiv¡Td%ci^ahnb#yjgJLahel jejAl=ä† ¶$0ryVmtga aˆax*SÁidÁKCgdcobkXlRtzing qlo!KBgmb{@ÎY;*  `/˚ CÓd of$v·RXableq dtslcRaq)On./GMN	ENL:vaah·Bmes
}
