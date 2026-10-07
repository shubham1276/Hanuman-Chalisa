package com.example.data

import com.example.model.ChalisaVerse
import com.example.model.VerseType

object ChalisaData {
    val verses: List<ChalisaVerse> = listOf(
        // Opening Doha 1
        ChalisaVerse(
            id = 0,
            type = VerseType.DOHA,
            numberTitle = "Opening Doha 1",
            numberTitleHindi = "प्रारंभिक दोहा १",
            hindiText = "श्रीगुरु चरन सरोज रज, निज मनु मुकुरु सुधारि।\nबरनउँ रघुबर बिमल जसु, जो दायकु फल चारि॥",
            englishTranslit = "Shri Guru charan saroj raj, nij manu mukuru sudhari.\nBaranau raghubar bimal jasu, jo dayaku phal chari.",
            gujaratiText = "શ્રીગુરુ ચરન સરોજ રજ, નિજ મનુ મુકુરુ સુધારિ.\nબરનઉં રઘુબર બિમલ જસુ, જો દાયકુ ફલ ચારિ.",
            marathiText = "श्रीगुरु चरण सरोज रज, निज मन मुकुरु सुधारि।\nवर्णव रघुवर विमल यश, जो दायक फल चारि॥",
            hindiMeaning = "श्री गुरुदेव के चरण-कमलों की पावन धूल से अपने मन रूपी दर्पण को स्वच्छ करके, मैं श्री रघुवीर के निर्मल यश का गान करता हूँ, जो जीवन के चारों फल (धर्म, अर्थ, काम और मोक्ष) प्रदान करता है।",
            englishMeaning = "Cleansing the mirror of my mind with the sacred dust of the Guru's lotus feet, I sing the unblemished glory of Lord Rama, which bestows the four great fruits of life (Righteousness, Wealth, Desire, and Liberation)."
        ),
        // Opening Doha 2
        ChalisaVerse(
            id = 1,
            type = VerseType.DOHA,
            numberTitle = "Opening Doha 2",
            numberTitleHindi = "प्रारंभिक दोहा २",
            hindiText = "बुद्धिहीन तनु जानिके, सुमिरौं पवन-कुमार।\nबल बुधि बिद्या देहु मोहिं, हरहु कलेस बिकार॥",
            englishTranslit = "Buddhiheen tanu janike, sumirau pawan-kumar.\nBala budhi bidya dehu mohi, harahu kales bikar.",
            gujaratiText = "બુદ્ધિહીન તનુ જાનિકે, સુમિરૌં પવન-કુમાર.\nબલ બુધિ બિદ્યા દેહુ મોહિં, હરહુ કલેસ બિકાર.",
            marathiText = "बुद्धिहीन तनु जानिके, सुमिरौं पवन-कुमार।\nबल बुद्धि विद्या देहु मोहि, हरहु क्लेश विकार॥",
            hindiMeaning = "हे पवनपुत्र! मैं स्वयं को ज्ञान और बुद्धि से हीन जानकर आपका स्मरण करता हूँ। मुझे शारीरिक बल, सद्बुद्धि और विद्या प्रदान करें तथा मेरे सभी कष्टों और मनोविकारों को दूर करें।",
            englishMeaning = "Knowing myself to be lacking in wisdom, I meditate upon you, O son of the Wind! Bestow upon me physical strength, keen intellect, and pure knowledge, and take away all my troubles and shortcomings."
        ),

        // Chaupai 1
        ChalisaVerse(
            id = 2,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 1",
            numberTitleHindi = "चौपाई १",
            hindiText = "जय हनुमान ज्ञान गुन सागर।\nजय कपीस तिहुँ लोक उजागर॥",
            englishTranslit = "Jai Hanuman gyan guna sagar.\nJai Kapees tihun loka ujagar.",
            gujaratiText = "જય હનુમાન જ્ઞાન ગુન સાગર.\nજય કપીસ તિહું લોક ઉજાગર.",
            marathiText = "जय हनुमान ज्ञान गुण सागर।\nजय कपीश तिहूं लोक उजागर॥",
            hindiMeaning = "ज्ञान और गुणों के अगाध सागर श्री हनुमान जी की जय हो! तीनों लोकों में वानर शिरोमणि आपकी कीर्ति का प्रकाश फैला हुआ है।",
            englishMeaning = "Victory to Hanuman, boundless ocean of wisdom and virtues! Victory to the king of monkeys whose divine radiance illuminates all three realms."
        ),
        // Chaupai 2
        ChalisaVerse(
            id = 3,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 2",
            numberTitleHindi = "चौपाई २",
            hindiText = "राम दूत अतुलित बल धामा।\nअंजनि-पुत्र पवनसुत नामा॥",
            englishTranslit = "Ram doot atulit bala dhama.\nAnjani-putra Pawansut nama.",
            gujaratiText = "રામ દૂત અતુલિત બલ ધામા.\nઅંજની-પુત્ર પવનસુત નામા.",
            marathiText = "राम दूत अतुलित बल धामा।\nअंजनि-पुत्र पवनसुत नामा॥",
            hindiMeaning = "आप प्रभु श्री राम के परम दूत और अतुलनीय बल के धाम हैं। आप माता अंजनी के पुत्र और पवनसुत नाम से पूजनीय हैं।",
            englishMeaning = "You are Lord Rama's supreme messenger and the abode of immeasurable might. You are known as Mother Anjani's son and the beloved child of the Wind God."
        ),
        // Chaupai 3
        ChalisaVerse(
            id = 4,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 3",
            numberTitleHindi = "चौपाई ३",
            hindiText = "महाबीर बिक्रम बजरंगी।\nकुमति निवार सुमति के संगी॥",
            englishTranslit = "Mahabeer bikram bajrangi.\nKumati nivar sumati ke sangi.",
            gujaratiText = "મહાબીર બિક્રમ બજરંગી.\nકુમતિ નિવાર સુમતિ કે સંગી.",
            marathiText = "महावीर विक्रम बजरंगी।\nकुमति निवार सुमति के संगी॥",
            hindiMeaning = "आप महान वीर और वज्र के समान शक्तिशाली शरीर वाले हैं। आप कुबुद्धि को दूर करने वाले और सद्बुद्धि के साथी हैं।",
            englishMeaning = "You are a great warrior with a body as resilient and radiant as thunder. You dispel evil thoughts and remain an eternal companion to wisdom."
        ),
        // Chaupai 4
        ChalisaVerse(
            id = 5,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 4",
            numberTitleHindi = "चौपाई ४",
            hindiText = "कंचन बरन बिराज सुबेसा।\nकानन कुंडल कुंचित केसा॥",
            englishTranslit = "Kanchan baran biraj subesa.\nKanan kundal kunchit kesa.",
            gujaratiText = "કંચન બરન બિરાજ સુબેસા.\nકાનન કુંડલ કુંચિત કેસા.",
            marathiText = "कंचन वरण विराज सुवेषा।\nकानन कुंडल कुंचित केशा॥",
            hindiMeaning = "आपका वर्ण सुवर्ण के समान कांतिमान और वेशभूषा मनोहारी है। कानों में सुंदर कुंडल और घुंघराले बाल शोभायमान हैं।",
            englishMeaning = "Your complexion gleams like molten gold and you are adorned with splendid garments, shimmering earrings in your ears, and curly hair."
        ),
        // Chaupai 5
        ChalisaVerse(
            id = 6,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 5",
            numberTitleHindi = "चौपाई ५",
            hindiText = "हाथ बज्र औ ध्वजा बिराजै।\nकाँधे मूँज जनेऊ साजै॥",
            englishTranslit = "Hath bajra au dhwaja birajai.\nKandhe moonj janeu saajai.",
            gujaratiText = "હાથ બજ્ર ઔ ધ્વજા બિરાજૈ.\nકાંધે મૂંજ જનેઊ સાજૈ.",
            marathiText = "हात वज्र औ ध्वजा विराजे।\nखांद्यावर मुंज जानवे साजे॥",
            hindiMeaning = "आपके हाथों में वज्र और विजय ध्वजा सुशोभित है, तथा आपके कंधे पर पवित्र मूंज का जनेऊ विराजित है।",
            englishMeaning = "In your hands rest the lightning mace and the banner of truth, while your shoulder is graced with the holy sacred thread."
        ),
        // Chaupai 6
        ChalisaVerse(
            id = 7,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 6",
            numberTitleHindi = "चौपाई ६",
            hindiText = "संकर सुवन केसरीनंदन।\nतेज प्रताप महा जग बंदन॥",
            englishTranslit = "Sankar suwan Kesarinandan.\nTej pratap maha jag bandan.",
            gujaratiText = "સંકર સુવન કેસરીનંદન.\nતેજ પ્રતાપ મહા જગ બંદન.",
            marathiText = "शंकर सुवन केसरीनंदन।\nतेज प्रताप महा जग वंदन॥",
            hindiMeaning = "आप भगवान शंकर के अवतार और महाराज केसरी के पुत्र हैं। आपके असीम तेज और पराक्रम की वंदना समस्त जगत करता है।",
            englishMeaning = "You are an incarnation of Lord Shiva and the joy of King Kesari. The entire universe reveres your radiant splendor and valiant glory."
        ),
        // Chaupai 7
        ChalisaVerse(
            id = 8,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 7",
            numberTitleHindi = "चौपाई ७",
            hindiText = "बिद्यावान गुनी अति चातुर।\nराम काज करिबे को आतुर॥",
            englishTranslit = "Bidyawan guni ati chatur.\nRam kaj karibe ko aatur.",
            gujaratiText = "બિદ્યાવાન ગુની અતિ ચાતુર.\nરામ કાજ કરિબે કો આતુર.",
            marathiText = "विद्यावान गुणी अति चतुर।\nराम काज करिबे को आतुर॥",
            hindiMeaning = "आप परम विद्वान, सर्वगुण सम्पन्न और अत्यंत चतुर हैं। श्री राम के कार्यों को सिद्ध करने के लिए आप सदैव उत्सुक रहते हैं।",
            englishMeaning = "You are learned, virtuous, and exceptionally wise, always enthusiastically eager to accomplish Lord Rama's noble tasks."
        ),
        // Chaupai 8
        ChalisaVerse(
            id = 9,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 8",
            numberTitleHindi = "चौपाई ८",
            hindiText = "प्रभु चरित्र सुनिबे को रसिया।\nराम लखन सीता मन बसिया॥",
            englishTranslit = "Prabhu charitra sunibe ko rasiya.\nRam Lakhan Sita man basiya.",
            gujaratiText = "પ્રભુ ચરિત્ર સુનિબે કો રસિયા.\nરામ લખન સીતા મન બસિયા.",
            marathiText = "प्रभू चरित्र सुनिबे को रसिया।\nराम लखन सीता मन बसिया॥",
            hindiMeaning = "आप प्रभु श्री राम की कथाओं को सुनने के परम प्रेमी हैं। आपके पावन हृदय में श्री राम, लक्ष्मण और माता सीता सदैव वास करते हैं।",
            englishMeaning = "You revel in listening to the sacred story of the Lord; Sri Rama, Lakshmana, and Mother Sita dwell eternally in your heart."
        ),
        // Chaupai 9
        ChalisaVerse(
            id = 10,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 9",
            numberTitleHindi = "चौपाई ९",
            hindiText = "सूक्ष्म रूप धरि सियहिं दिखावा।\nबिकट रूप धरि लंक जरावा॥",
            englishTranslit = "Sookshma roop dhari siyahi dikhava.\nBikat roop dhari lanka jarava.",
            gujaratiText = "સૂક્ષ્મ રૂપ ધરિ સિયહિં દિખાવા.\nબિકટ રૂપ ધરિ લંક જરાવા.",
            marathiText = "सूक्ष्म रूप धरि सियहिं दिखावा।\nविकट रूप धरि लंका जरावा॥",
            hindiMeaning = "आपने माता सीता के सम्मुख अति सूक्ष्म रूप धारण कर दर्शन दिए, और फिर विकराल रूप धारण करके लंका को भस्म कर दिया।",
            englishMeaning = "Assuming an exceedingly tiny form, you appeared before Mother Sita in humility, and taking a formidable colossal form, you set ablaze the golden city of Lanka."
        ),
        // Chaupai 10
        ChalisaVerse(
            id = 11,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 10",
            numberTitleHindi = "चौपाई १०",
            hindiText = "भीम रूप धरि असुर संहारे।\nरामचंद्र के काज संवारे॥",
            englishTranslit = "Bheem roop dhari asura sanhare.\nRamchandra ke kaj sanware.",
            gujaratiText = "ભીમ રૂપ ધરિ અસુર સંહારે.\nરામચંદ્ર કે કાજ સંવારે.",
            marathiText = "भीम रूप धरि असुर संहारे।\nरामचंद्र के काज संवारे॥",
            hindiMeaning = "आपने भीमकाय विशाल रूप धारण करके दुष्ट असुरों का संहार किया और भगवान श्री रामचंद्र जी के सभी कार्यों को संवारा।",
            englishMeaning = "Assuming a mighty titanic form, you vanquished demonic forces and accomplished all the missions of Lord Ramachandra."
        ),
        // Chaupai 11
        ChalisaVerse(
            id = 12,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 11",
            numberTitleHindi = "चौपाई ११",
            hindiText = "लाय सजीवन लखन जियाये।\nश्रीरघुबीर हरषि उर लाये॥",
            englishTranslit = "Laye sajeevan Lakhan jiyaye.\nShri Raghubeer harashi ur laye.",
            gujaratiText = "લાય સજીવન લખન જિયાયે.\nશ્રીરઘુબીર હરષિ ઉર લાયે.",
            marathiText = "लाय सजीवन लखन जियाये।\nश्रीरघुवीर हरषि उर लाये॥",
            hindiMeaning = "आप संजीवनी बूटी लाकर लक्ष्मण जी को नया जीवन प्रदान किए। इससे हर्षित होकर श्री रामचंद्र जी ने आपको प्रेम से हृदय से लगा लिया।",
            englishMeaning = "You brought the life-saving Sanjeevani herb and revived Lakshmana. Overjoyed with gratitude, Lord Rama embraced you to His heart."
        ),
        // Chaupai 12
        ChalisaVerse(
            id = 13,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 12",
            numberTitleHindi = "चौपाई १२",
            hindiText = "रघुपति कीन्ही बहुत बड़ाई।\nतुम्ह मम प्रिय भरतहि सम भाई॥",
            englishTranslit = "Raghupati keenhi bahut badayi.\nTumha mama priya Bharat-hi sam bhai.",
            gujaratiText = "રઘુપતિ કીન્હી બહુત બડ઼ાઈ.\nતુમ્હ મમ પ્રિય ભરતહિ સમ ભાઈ.",
            marathiText = "रघुपती कीन्ही बहुत बड़ाई।\nतुम्ह मम प्रिय भरतहि सम भाई॥",
            hindiMeaning = "भगवान श्री राम ने आपकी भूरि-भूरि प्रशंसा की और कहा कि तुम मुझे भरत जैसे ही प्यारे भाई हो।",
            englishMeaning = "Lord Rama praised you wholeheartedly, declaring: 'You are as beloved to me as my dear brother Bharata!'"
        ),
        // Chaupai 13
        ChalisaVerse(
            id = 14,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 13",
            numberTitleHindi = "चौपाई १३",
            hindiText = "सहस बदन तुम्हरो जस गावैं।\nअस कहि श्रीपति कंठ लगावैं॥",
            englishTranslit = "Sahas badan tumharo jas gavain.\nAs kahi Shripati kantha lagavain.",
            gujaratiText = "સહસ બદન તુમ્હરો જસ ગાવૈં.\nઅસ કહિ શ્રીપતિ કંઠ લગાવૈં.",
            marathiText = "सहस वदन तुम्हरो जस गावैं।\nअस कहि श्रीपति कंठ लगावैं॥",
            hindiMeaning = "हज़ार मुखों वाले शेषनाग भी आपके यश का गुणगान करते हैं—यह कहकर लक्ष्मीपति श्री राम ने आपको फिर गले लगाया।",
            englishMeaning = "'Even the thousand-headed Sheshanaga sings your glory,' saying this, Lord Rama embraced you closely."
        ),
        // Chaupai 14
        ChalisaVerse(
            id = 15,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 14",
            numberTitleHindi = "चौपाई १४",
            hindiText = "सनकादिक ब्रह्मादि मुनीसा।\nनारद सारद सहित अहीसा॥",
            englishTranslit = "Sanakadika Brahmadi Muneesa.\nNarad Sarad sahit Aheesa.",
            gujaratiText = "સનકાદિક બ્રહ્માદિ મુનીસા.\nનારદ સારદ સહિત અહીસા.",
            marathiText = "सनकादिक ब्रह्मादि मुनीशा।\nनारद शारद सहित अहीशा॥",
            hindiMeaning = "सनक आदि महर्षि, ब्रह्मा आदि देवता, मुनिगण, देवर्षि नारद, माता सरस्वती और शेषनाग सभी आपकी कीर्ति का गान करते हैं।",
            englishMeaning = "Sanaka and the great sages, Brahma and the cosmic gods, celestial singer Narada, Goddess Saraswati, and the serpent king Shesha all revere your glory."
        ),
        // Chaupai 15
        ChalisaVerse(
            id = 16,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 15",
            numberTitleHindi = "चौपाई १५",
            hindiText = "जम कुबेर दिगपाल जहाँ ते।\nकबि कोबिद कहि सके कहाँ ते॥",
            englishTranslit = "Jam Kuber Digpal jahan te.\nKabi kobid kahi sake kahan te.",
            gujaratiText = "જમ કુબેર દિગપાલ જહાં તે.\nકબિ કોબિદ કહિ સકે કહાં તે.",
            marathiText = "यम कुबेर दिगपाल जहाँ ते।\nकवि कोविद कहि सके कहाँ ते॥",
            hindiMeaning = "यमराज, कुबेर और दसों दिशाओं के रक्षक भी जब आपकी महिमा का पार नहीं पा सकते, तो साधारण कवि और विद्वान कैसे कह सकते हैं!",
            englishMeaning = "When Yamaraja (god of death), Kubera (god of wealth), and all guardians of directions cannot fully express your praise, how can human poets encompass your glory?"
        ),
        // Chaupai 16
        ChalisaVerse(
            id = 17,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 16",
            numberTitleHindi = "चौपाई १६",
            hindiText = "तुम्ह उपकार सुग्रीवहिं कीन्हा।\nराम मिलाय राज पद दीन्हा॥",
            englishTranslit = "Tumha upakar Sugreevahin keenha.\nRam milaye raj pad deenha.",
            gujaratiText = "તુમ્હ ઉપકાર સુગ્રીવહિં કીન્હા.\nરામ મિલાય રાજ પદ દીન્હા.",
            marathiText = "तुम्ह उपकार सुग्रीवहिं कीन्हा।\nराम मिलाय राज पद दीन्हा॥",
            hindiMeaning = "आपने सुग्रीव पर महान उपकार किया, उन्हें श्री राम से मिलाया और उनका खोया हुआ राजपद पुनः दिलवाया।",
            englishMeaning = "You rendered immense assistance to Sugriva by uniting him with Sri Rama, restoring his dignity and crowning him king."
        ),
        // Chaupai 17
        ChalisaVerse(
            id = 18,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 17",
            numberTitleHindi = "चौपाई १७",
            hindiText = "तुम्हारो मंत्र बिभीषन माना।\nलंकेस्वर भए सब जग जाना॥",
            englishTranslit = "Tumharo mantra Bibheeshan mana.\nLankeshwar bhaye sab jag jana.",
            gujaratiText = "તુમ્હારો મંત્ર બિભીષન માના.\nલંકેસ્વર ભએ સબ જગ જાના.",
            marathiText = "तुम्हारो मंत्र विभीषण माना।\nलंकेश्वर भये सब जग जाना॥",
            hindiMeaning = "आपके परामर्श को विभीषण ने माना, जिसके फलस्वरूप वे लंका के राजा बने—यह बात सारा संसार जानता है।",
            englishMeaning = "Vibhishana heeded your righteous counsel, becoming the sovereign king of Lanka, as known throughout the whole universe."
        ),
        // Chaupai 18
        ChalisaVerse(
            id = 19,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 18",
            numberTitleHindi = "चौपाई १८",
            hindiText = "जुग सहस्र जोजन पर भानू।\nलील्यो ताहि मधुर फल जानू॥",
            englishTranslit = "Juga sahasra jojan par bhanu.\nLeelyo tahi madhur phal janu.",
            gujaratiText = "જુગ સહસ્ર જોજન પર ભાનૂ.\nલીલ્યો તાહિ મધુર ફલ જાનૂ.",
            marathiText = "युग सहस्र योजन पर भानू।\nलील्यो ताहि मधुर फल जानू॥",
            hindiMeaning = "हज़ारों योजन की दूरी पर स्थित सूर्य को आपने बाल्यकाल में एक मीठा फल समझकर अनायास ही निगल लिया था।",
            englishMeaning = "The Sun, situated millions of miles away in cosmic space, you playfully reached and swallowed, mistaking it for a sweet ripe fruit."
        ),
        // Chaupai 19
        ChalisaVerse(
            id = 20,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 19",
            numberTitleHindi = "चौपाई १९",
            hindiText = "प्रभु मुद्रिका मेलि मुख माहीं।\nजलधि लाँघि गये अचरज नाहीं॥",
            englishTranslit = "Prabhu mudrika meli mukh maheen.\nJaladhi langhi gaye achraj naaheen.",
            gujaratiText = "પ્રભુ મુદ્રિકા મેલિ મુખ માહીં.\nજલધિ લાંઘિ ગયે અચરજ નાહીં.",
            marathiText = "प्रभू मुद्रिका मेलि मुख माहीं।\nजलधि लांघि गये अचरज नाहीं॥",
            hindiMeaning = "प्रभु श्री राम की अंगूठी को मुख में रखकर आपने विशाल समुद्र को सहज ही लांघ लिया, इसमें कोई आश्चर्य नहीं है।",
            englishMeaning = "Holding Lord Rama's signet ring within your mouth, you leaped effortlessly across the vast ocean—no wonder for someone of your supreme power!"
        ),
        // Chaupai 20
        ChalisaVerse(
            id = 21,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 20",
            numberTitleHindi = "चौपाई २०",
            hindiText = "दुर्गम काज जगत के जेते।\nसुगम अनुग्रह तुम्हरे तेते॥",
            englishTranslit = "Durgam kaj jagat ke jete.\nSugam anugrah tumhre tete.",
            gujaratiText = "દુર્ગમ કાજ જગત કે જેતે.\nસુગમ અનુગ્રહ તુમ્હરે તેતે.",
            marathiText = "दुर्गम काज जगत के जेते।\nसुगम अनुग्रह तुम्हरे तेते॥",
            hindiMeaning = "संसार के जितने भी कठिन और असंभव कार्य हैं, वे आपकी कृपा मात्र से सहज और सुगम हो जाते हैं।",
            englishMeaning = "Whatever arduous tasks exist in this world become smooth and easy by your divine grace."
        ),
        // Chaupai 21
        ChalisaVerse(
            id = 22,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 21",
            numberTitleHindi = "चौपाई २१",
            hindiText = "राम दुआरे तुम रखवारे।\nहोत न आज्ञा बिनु पैसारे॥",
            englishTranslit = "Ram duware tum rakhware.\nHot na agya binu paisare.",
            gujaratiText = "રામ દુઆરે તુમ રખવારે.\nહોત ન આજ્ઞા બિનુ પૈસારે.",
            marathiText = "राम द्वारे तुम रखवारे।\nहोत न आज्ञा बिनु पैसारे॥",
            hindiMeaning = "आप प्रभु श्री राम के द्वारपाल हैं; आपकी आज्ञा और अनुमति के बिना कोई भी अंदर प्रवेश नहीं पा सकता।",
            englishMeaning = "You are the loving gatekeeper at Sri Rama's portal; no one can enter His presence without your blessed sanction."
        ),
        // Chaupai 22
        ChalisaVerse(
            id = 23,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 22",
            numberTitleHindi = "चौपाई २२",
            hindiText = "सब सुख लहै तुम्हारी सरना।\nतुम रक्षक काहू को डर ना॥",
            englishTranslit = "Sab sukh lahai tumhari sarna.\nTum rakshak kahu ko darna.",
            gujaratiText = "સબ સુખ લહૈ તુમ્હારી સરના.\nતુમ રક્ષક કાહૂ કો ડર ના.",
            marathiText = "सब सुख लहै तुम्हारी सरना।\nतुम रक्षक काहू को डर ना॥",
            hindiMeaning = "आपकी शरण में आने वाले को संसार के सभी सुख प्राप्त होते हैं। जब आप रक्षक हैं, तो किसी प्रकार का कोई भय नहीं रहता।",
            englishMeaning = "All happiness and peace are found in your sanctuary; when you are the protector, what fear can touch anyone?"
        ),
        // Chaupai 23
        ChalisaVerse(
            id = 24,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 23",
            numberTitleHindi = "चौपाई २३",
            hindiText = "आपन तेज सम्हारो आपै।\nतीनों लोक हाँक तें काँपै॥",
            englishTranslit = "Aapan tej samharo aapai.\nTeenon lok haank ten kaanpai.",
            gujaratiText = "આપન તેજ સમ્હારો આપૈ.\nતીનોં લોક હાંક તેં કાંપૈ.",
            marathiText = "आपन तेज सम्हारो आपै।\nतीनों लोक हांक तें कांपै॥",
            hindiMeaning = "अपने असीम तेज और वेग को केवल आप ही संभाल सकते हैं। आपके एक गर्जन मात्र से तीनों लोक कांप उठते हैं।",
            englishMeaning = "You alone can sustain your boundless cosmic brilliance; at the sound of your mighty roar, all three worlds tremble in awe."
        ),
        // Chaupai 24
        ChalisaVerse(
            id = 25,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 24",
            numberTitleHindi = "चौपाई २४",
            hindiText = "भूत पिसाच निकट नहिं आवै।\nमहाबीर जब नाम सुनावै॥",
            englishTranslit = "Bhoot pisach nikat nahin aavai.\nMahabeer jab naam sunavai.",
            gujaratiText = "ભૂત પિસાચ નિકટ નહિં આવૈ.\nમહાબીર જબ નામ સુનાવૈ.",
            marathiText = "भूत पिशाच निकट नहिं आवै।\nमहावीर जब नाम सुनावै॥",
            hindiMeaning = "महावीर हनुमान जी का नाम सुनते ही भूत, पिशाच और समस्त नकारात्मक शक्तियाँ पास भी नहीं फटकती हैं।",
            englishMeaning = "Ghosts, spirits, and harmful negative forces never dare approach wherever the holy name of Mahavira Hanuman is chanted."
        ),
        // Chaupai 25
        ChalisaVerse(
            id = 26,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 25",
            numberTitleHindi = "चौपाई २५",
            hindiText = "नासै रोग हरै सब पीरा।\nजपत निरंतर हनुमत बीरा॥",
            englishTranslit = "Nase rog harai sab peera.\nJapat nirantar Hanumat beera.",
            gujaratiText = "નાસૈ રોગ હરૈ સબ પીરા.\nજપત નિરંતર હનુમત બીરા.",
            marathiText = "नाशै रोग हरै सब पीरा।\nजपत निरंतर हनुमत बीरा॥",
            hindiMeaning = "वीर हनुमान जी के नाम का निरंतर जप करने से सभी प्रकार के रोग नष्ट हो जाते हैं और समस्त पीड़ाएं दूर हो जाती हैं।",
            englishMeaning = "All illnesses are vanquished and all suffering is removed for those who persistently meditate upon the courageous Hanuman."
        ),
        // Chaupai 26
        ChalisaVerse(
            id = 27,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 26",
            numberTitleHindi = "चौपाई २६",
            hindiText = "संकट तें हनुमान छुड़ावै।\nमन क्रम बचन ध्यान जो लावै॥",
            englishTranslit = "Sankat te Hanuman chhudavai.\nMan kram bachan dhyan jo lavai.",
            gujaratiText = "સંકટ તેં હનુમાન છુડ઼ાવૈ.\nમન ક્રમ બચન ધ્યાન જો લાવૈ.",
            marathiText = "संकट तें हनुमान छुड़ावै।\nमन क्रम वचन ध्यान जो लावै॥",
            hindiMeaning = "जो व्यक्ति मन, कर्म और वाणी से हनुमान जी का ध्यान करता है, हनुमान जी उसे हर संकट से मुक्त कर देते हैं।",
            englishMeaning = "Hanuman liberates from all distress anyone who contemplates Him with devotion in thought, word, and deed."
        ),
        // Chaupai 27
        ChalisaVerse(
            id = 28,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 27",
            numberTitleHindi = "चौपाई २७",
            hindiText = "सब पर राम तपस्वी राजा।\nतिन के काज सकल तुम साजा॥",
            englishTranslit = "Sab par Ram tapaswee raja.\nTin ke kaj sakal tum saja.",
            gujaratiText = "સબ પર રામ તપસ્વી રાજા.\nતિન કે કાજ સકલ તુમ સાજા.",
            marathiText = "सब पर राम तपस्वी राजा।\nतिन के काज सकल तुम साजा॥",
            hindiMeaning = "तपस्वी राजा श्री रामचंद्र जी सबसे श्रेष्ठ हैं, और उनके सभी दुरूह कार्यों को आपने ही पूर्णता से संवारा है।",
            englishMeaning = "Sri Rama is the supreme ascetic monarch, and you sovereignly executed and fulfilled all His divinely planned endeavors."
        ),
        // Chaupai 28
        ChalisaVerse(
            id = 29,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 28",
            numberTitleHindi = "चौपाई २८",
            hindiText = "और मनोरथ जो कोई लावै।\nसोइ अमित जीवन फल पावै॥",
            englishTranslit = "Aur manorath jo koi lavai.\nSoi amit jeevan phal pavai.",
            gujaratiText = "ઔર મનોરથ જો કોઈ લાવૈ.\nસોઇ અમિત જીવન ફલ પાવૈ.",
            marathiText = "और मनोरथ जो कोई लावै।\nसोई अमित जीवन फल पावै॥",
            hindiMeaning = "जो कोई भी शुद्ध हृदय से आपके समक्ष अपनी मनोकामना लेकर आता है, वह अपने जीवन में अनंत और अमर फल प्राप्त करता है।",
            englishMeaning = "Whoever brings sincere wishes to your altar attains the limitless and sublime fruits of life."
        ),
        // Chaupai 29
        ChalisaVerse(
            id = 30,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 29",
            numberTitleHindi = "चौपाई २९",
            hindiText = "चारों जुग परताप तुम्हारा।\nहै परसिद्ध जगत उजियारा॥",
            englishTranslit = "Charon jug partap tumhara.\nHai parsiddha jagat ujiyara.",
            gujaratiText = "ચારોં જુગ પરતાપ તુમ્હારા.\nહૈ પરસિદ્ધ જગત ઉજિયારા.",
            marathiText = "चारों युग परताप तुम्हारा।\nहै प्रसिद्ध जगत उजियारा॥",
            hindiMeaning = "सत्ययुग, त्रेता, द्वापर और कलयुग—चारों युगों में आपका तेज और प्रताप व्याप्त है, और आपका यश सारे जगत को प्रकाशित करता है।",
            englishMeaning = "Your exalted glory shines throughout all four ages (Yugas), illuminating the whole world with divine light."
        ),
        // Chaupai 30
        ChalisaVerse(
            id = 31,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 30",
            numberTitleHindi = "चौपाई ३०",
            hindiText = "साधु-संत के तुम रखवारे।\nअसुर निकंदन राम दुलारे॥",
            englishTranslit = "Sadhu-sant ke tum rakhware.\nAsur nikandan Ram dulare.",
            gujaratiText = "સાધુ-સંત કે તુમ રખવારે.\nઅસુર નિકંદન રામ દુલારે.",
            marathiText = "साधु-संत के तुम रखवारे।\nअसुर निकंदन राम दुलारे॥",
            hindiMeaning = "आप सज्जनों और संतों की रक्षा करने वाले, दुष्टों और असुरों का नाश करने वाले, तथा श्री राम के परम प्रिय हैं।",
            englishMeaning = "You are the devoted guardian of saints and virtuous souls, the destroyer of wicked forces, and Lord Rama's cherished darling."
        ),
        // Chaupai 31
        ChalisaVerse(
            id = 32,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 31",
            numberTitleHindi = "चौपाई ३१",
            hindiText = "अष्ट सिद्धि नौ निधि के दाता।\nअस बर दीन जानकी माता॥",
            englishTranslit = "Ashta siddhi nau nidhi ke data.\nAs bar deen Janaki Mata.",
            gujaratiText = "અષ્ટ સિદ્ધિ નૌ નિધિ કે દાતા.\nઅસ બર દીન જાનકી માતા.",
            marathiText = "अष्ट सिद्धि नौ निधि के दाता।\nअसा वर दीन जानकी माता॥",
            hindiMeaning = "आप आठों सिद्धियों और नौ निधियों को प्रदान करने वाले हैं; यह मंगलकारी वरदान आपको पूज्या माता जानकी ने दिया है।",
            englishMeaning = "You are the bestower of the eight supernatural powers and the nine divine treasures, a blessed boon granted to you by Mother Janaki."
        ),
        // Chaupai 32
        ChalisaVerse(
            id = 33,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 32",
            numberTitleHindi = "चौपाई ३२",
            hindiText = "राम रसायन तुम्हरे पासा।\nसदा रहो रघुपति के दासा॥",
            englishTranslit = "Ram rasayan tumhre pasa.\nSada raho Raghupati ke dasa.",
            gujaratiText = "રામ રસાયન તુમ્હરે પાસા.\nસદા રહો રઘુપતિ કે દાસા.",
            marathiText = "राम रसायन तुम्हरे पासा।\nसदा रहो रघुपति के दासा॥",
            hindiMeaning = "आपके पास श्री राम नाम रूपी परम औषधि (अमृत) है। आप सदा-सदा प्रभु श्री रघुनाथ जी के अनन्य सेवक रहते हैं।",
            englishMeaning = "You hold the elixir of Lord Rama's nectarine name, ever serving as His humblest and most devoted disciple."
        ),
        // Chaupai 33
        ChalisaVerse(
            id = 34,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 33",
            numberTitleHindi = "चौपाई ३३",
            hindiText = "तुम्हरे भजन राम को पावै।\nजनम-जनम के दुख बिसरावै॥",
            englishTranslit = "Tumhre bhajan Ram ko pavai.\nJanam janam ke dukh bisravai.",
            gujaratiText = "તુમ્હરે ભજન રામ કો પાવૈ.\nજનમ-જનમ કે દુખ બિસરાવૈ.",
            marathiText = "तुम्हरे भजन राम को पावै।\nजनम जनम के दुःख विसरावै॥",
            hindiMeaning = "आपके भजन और कीर्तन से मनुष्य श्री राम को प्राप्त कर लेता है और जन्म-जन्मांतर के संचित दुखों को भूल जाता है।",
            englishMeaning = "Singing your praises leads directly to Lord Rama and dissolves the sorrows accumulated across lifetimes."
        ),
        // Chaupai 34
        ChalisaVerse(
            id = 35,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 34",
            numberTitleHindi = "चौपाई ३४",
            hindiText = "अंत काल रघुबर पुर जाई।\nजहाँ जन्म हरि-भक्त कहाई॥",
            englishTranslit = "Anta kal Raghubar pur jai.\nJahan janma Hari-bhakta kahai.",
            gujaratiText = "અંત કાલ રઘુબર પુર જાઈ.\nજહાં જન્મ હરિ-ભક્ત કહાઈ.",
            marathiText = "अंत काल रघुवर पुर जाई।\nजिथे जन्म हरी-भक्त कहाई॥",
            hindiMeaning = "आपके स्मरण से अंत समय में जीव श्री राम के परम धाम (साकेत) जाता है, और यदि पुनर्जन्म भी हो तो वह अनन्य हरि-भक्त बनता है।",
            englishMeaning = "At life's departure, your devotee enters Lord Rama's celestial abode, and whenever taking birth, remains revered as a true servant of God."
        ),
        // Chaupai 35
        ChalisaVerse(
            id = 36,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 35",
            numberTitleHindi = "चौपाई ३५",
            hindiText = "और देवता चित्त न धरई।\nहनुमत सेइ सर्ब सुख करई॥",
            englishTranslit = "Aur devata chitta na dharayi.\nHanumat sei sarba sukh karayi.",
            gujaratiText = "ઔર દેવતા ચિત્ત ન ધરઈ.\nહનુમત સેઇ સર્બ સુખ કરઈ.",
            marathiText = "और देवता चित्त न धरई।\nहनुमत सेई सर्व सुख करई॥",
            hindiMeaning = "किसी अन्य देवता का स्मरण न भी करे, तो भी केवल श्री हनुमान जी की सेवा-आराधना से समस्त प्रकार के सुख प्राप्त हो जाते हैं।",
            englishMeaning = "Even without invoking any other deities, through wholehearted devotion to Hanuman alone, one attains every blessing and delight."
        ),
        // Chaupai 36
        ChalisaVerse(
            id = 37,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 36",
            numberTitleHindi = "चौपाई ३६",
            hindiText = "संकट कटै मिटै सब पीरा।\nजो सुमिरै हनुमत बलबीरा॥",
            englishTranslit = "Sankat katai mitai sab peera.\nJo sumirai Hanumat balbeera.",
            gujaratiText = "સંકટ કટૈ મિટૈ સબ પીરા.\nજો સુમિરૈ હનુમત બલબીરા.",
            marathiText = "संकट कटै मिटै सब पीरा।\nजो सुमिरै हनुमत बलवीरा॥",
            hindiMeaning = "जो भी महाबली वीर हनुमान जी का स्मरण करता है, उसके सारे संकट कट जाते हैं और सारी पीड़ाएं मिट जाती हैं।",
            englishMeaning = "All troubles are severed and all agonies vanish for one who holds the valiant hero Hanuman in their heart."
        ),
        // Chaupai 37
        ChalisaVerse(
            id = 38,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 37",
            numberTitleHindi = "चौपाई ३७",
            hindiText = "जै जै जै हनुमान गोसाईं।\nकृपा करहु गुरुदेव की नाईं॥",
            englishTranslit = "Jai jai jai Hanuman gosain.\nKripa karahu gurudev ki naeen.",
            gujaratiText = "જૈ જૈ જૈ હનુમાન ગોસાઈં.\nકૃપા કરહુ ગુરુદેવ કી નાઈં.",
            marathiText = "जय जय जय हनुमान गोसाई।\nकृपा करहु गुरुदेव की नाई॥",
            hindiMeaning = "हे स्वामी हनुमान जी! आपकी सदा जय हो, जय हो, जय हो! आप मुझ पर परम कृपालु गुरुदेव के समान कृपा कीजिए।",
            englishMeaning = "Hail, all hail to you, O Lord Hanuman! Bestow your compassion upon me as gently and completely as a loving spiritual Master."
        ),
        // Chaupai 38
        ChalisaVerse(
            id = 39,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 38",
            numberTitleHindi = "चौपाई ३८",
            hindiText = "जो सत बार पाठ कर कोई।\nछूटहि बंदि महा सुख होई॥",
            englishTranslit = "Jo sat bar path kar koi.\nChhootahi bandi maha sukh hoyi.",
            gujaratiText = "જો સત બાર પાઠ કર કોઈ.\nછૂટહિ બંદિ મહા સુખ હોઈ.",
            marathiText = "जो शत बार पाठ कर कोई।\nछूटहि बंदि महा सुख होई॥",
            hindiMeaning = "जो कोई भी सौ बार इस पावन चालीसा का पाठ करता है, वह सभी प्रकार के बंधनों से मुक्त होकर परम आनंद प्राप्त करता है।",
            englishMeaning = "Whoever recites this prayer a hundred times is liberated from worldly bondages and attains supreme spiritual joy."
        ),
        // Chaupai 39
        ChalisaVerse(
            id = 40,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 39",
            numberTitleHindi = "चौपाई ३९",
            hindiText = "जो यह पढ़ै हनुमान चलीसा।\nहोय सिद्धि साखी गौरीसा॥",
            englishTranslit = "Jo yah padhai Hanuman Chalisa.\nHoye siddhi sakhee Gaurisa.",
            gujaratiText = "જો યહ પઢૈ હનુમાન ચલીસા.\nહોય સિદ્ધિ સાખી ગૌરીસા.",
            marathiText = "जो यह पढ़ै हनुमान चालीसा।\nहोय सिद्धि साक्षी गौरीशा॥",
            hindiMeaning = "जो भी इस हनुमान चालीसा का श्रद्धा से पाठ करता है, उसे सभी कार्यों में सिद्धि प्राप्त होती है—इसके साक्षी स्वयं भगवान शिव (गौरीश) हैं।",
            englishMeaning = "Whoever chants this Hanuman Chalisa attains spiritual perfection and fulfillment; Lord Shiva Himself stands witness to this truth."
        ),
        // Chaupai 40
        ChalisaVerse(
            id = 41,
            type = VerseType.CHAUPAI,
            numberTitle = "Chaupai 40",
            numberTitleHindi = "चौपाई ४०",
            hindiText = "तुलसीदास सदा हरि चेरा।\nकीजै नाथ हृदय महँ डेरा॥",
            englishTranslit = "Tulsidas sada Hari chera.\nKeejai nath hriday mahan dera.",
            gujaratiText = "તુલસીદાસ સદા હરિ ચેરા.\nકીજૈ નાથ હૃદય મહઁ ડેરા.",
            marathiText = "तुलसीदास सदा हरि चेरा।\nकीजै नाथ हृदय महं डेरा॥",
            hindiMeaning = "तुलसीदास सदा प्रभु श्री हरि के सेवक हैं। हे नाथ हनुमान जी! आप सदैव मेरे हृदय मंदिर में निवास कीजिए।",
            englishMeaning = "Tulsidas remains forever the servant of God; O beloved Lord Hanuman, please make your permanent home in my heart."
        ),

        // Closing Doha
        ChalisaVerse(
            id = 42,
            type = VerseType.DOHA,
            numberTitle = "Closing Doha",
            numberTitleHindi = "समापन दोहा",
            hindiText = "पवन तनय संकट हरन, मंगल मूरति रूप।\nराम लखन सीता सहित, हृदय बसहु सुर भूप॥",
            englishTranslit = "Pawan tanay sankat haran, mangal murati roop.\nRam Lakhan Sita sahit, hriday basahu sur bhoop.",
            gujaratiText = "પવન તનય સંકટ હરન, મંગલ મૂરતિ રૂપ.\nરામ લખન સીતા સહિત, હૃદય બસહુ સુર ભૂપ.",
            marathiText = "पवन तनय संकट हरण, मंगल मूरति रूप।\nराम लखन सीता सहित, हृदय बसहु सुर भूप॥",
            hindiMeaning = "हे संकटमोचन पवनपुत्र! आप समस्त संकटों को हरने वाले और साक्षात मंगल की मूर्ति हैं। आप देवों के स्वामी श्री राम, लक्ष्मण और माता सीता सहित सदा मेरे हृदय में वास करें।",
            englishMeaning = "O son of the Wind, dispeller of all tribulations and the living embodiment of auspiciousness! Abide forever in my heart together with Sri Rama, Lakshmana, and Mother Sita."
        )
    )

    fun getVerse(index: Int): ChalisaVerse {
        val safeIndex = index.coerceIn(0, verses.lastIndex)
        return verses[safeIndex]
    }
}
