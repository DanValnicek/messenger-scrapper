package main.java.com.company;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scrapper {
    //      Scrapes names


    protected static void lastMessage() {
        GlobalVariable.driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        List<WebElement> nameSrape = GlobalVariable.driver.findElements(By.className("_ih3"));
        WebElement lastName = nameSrape.get(nameSrape.size() - 1);
        String name = lastName.getText();
//        finding last message
        List<WebElement> find = GlobalVariable.driver.findElements(By.cssSelector(".clearfix ._o46"));
        WebElement lastFind = find.get(find.size() - 1);


        boolean msgSent = false;
        String finMsg = null;
        try {
            WebElement timeStamp = lastFind.findElement(By.className("_ui9"));
            String justTime = timeStamp.getAttribute("data-tooltip-content");
            WebElement send = lastFind.findElement(By.className("_aok"));
            finMsg = justTime + " **" + name + "**: " + send.getText();
            System.out.println(finMsg);
            msgSent = true;
        } catch (Exception e) {
            System.out.println("no text");
        }

        if (!msgSent) {
            try {
                WebElement timeStamp = lastFind.findElement(By.className("_3zvs"));
                String justTime = timeStamp.getAttribute("data-tooltip-content");
                List<WebElement> img = lastFind.findElements(By.className("_5pf5"));
                for (WebElement a : img) {
                    finMsg = justTime + " **" + name + "**: " + a.getAttribute("src");
                }
                System.out.println(finMsg);
                msgSent = true;
            } catch (Exception e) {
                System.out.println("no photo");
            }
        }

        if (!msgSent) {
            try {
                WebElement timeStamp = lastFind.findElement(By.className("_ui9"));
                String justTime = timeStamp.getAttribute("data-tooltip-content");
                List<WebElement> img = lastFind.findElements(By.className("_4pcn"));
                for (WebElement a : img) {
                    finMsg = justTime + " **" + name + "**: " + a.getAttribute("href");
                }
                System.out.println(finMsg);
            } catch (Exception e) {
                System.out.println("something is wrong");
            }
        }
        if(finMsg == null){
            System.out.println("null");
            return;
        }
        PostExample example = new PostExample();
        String json = "{\"token\": \"stabletest\",\n" +
                "    \"type\": \"msg\",\n" +
                "    \"body\":\"" + finMsg + "\"}";
        String response = null;
        try {
            response = example.post("https://tea-bot.eu-gb.mybluemix.net/api/triggers/send", json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
    }
}

 /*       WebElement send;
        List<WebElement> textPresence = null;
        textPresence = lastFind.findElements(By.className("_aok"));
        List<WebElement> imgPresence = null;
        imgPresence = lastFind.findElements(By.className("_4tsl"));
        List<WebElement> sendAtachment = new List<Weblement>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<WebElement> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(WebElement webElement) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends WebElement> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends WebElement> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public WebElement get(int i) {
                return null;
            }

            @Override
            public WebElement set(int i, WebElement webElement) {
                return null;
            }

            @Override
            public void add(int i, WebElement webElement) {

            }

            @Override
            public WebElement remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<WebElement> listIterator() {
                return null;
            }

            @Override
            public ListIterator<WebElement> listIterator(int i) {
                return null;
            }

            @Override
            public List<WebElement> subList(int i, int i1) {
                return null;
            }
        };
//        looking for text
        if (!textPresence.isEmpty()) {
            send = lastFind.findElement(By.className("_aok"));
            System.out.println(send.getText());
//            looking for image
        } else if (!imgPresence.isEmpty()) {
            lastFind.findElements(By.className("_4tsl"));
            for (WebElement a : sendAtachment) {
//                printing img URL
                System.out.println(a.getAttribute("href"));
            }
        } else {
            lastFind.findElements(By.className("_4pcn"));
            for (WebElement a : sendAtachment) {
//                printing file URL
                System.out.println(a.getAttribute("href"));
            }
        }
    }
}
/*
/*        //          Scrapes text
   protected static void textScrapper(String[] args) {
       WebElement lMsg = new WebElement() {
           @Override
           public void click() {

           }

           @Override
           public void submit() {

           }

           @Override
           public void sendKeys(CharSequence... keysToSend) {

           }

           @Override
           public void clear() {

           }

           @Override
           public String getTagName() {
               return null;
           }

           @Override
           public String getAttribute(String name) {
               return null;
           }

           @Override
           public boolean isSelected() {
               return false;
           }

           @Override
           public boolean isEnabled() {
               return false;
           }

           @Override
           public String getText() {
               return null;
           }

           @Override
           public List<WebElement> findElements(By by) {
               return null;
           }

           @Override
           public WebElement findElement(By by) {
               return null;
           }

           @Override
           public boolean isDisplayed() {
               return false;
           }

           @Override
           public Point getLocation() {
               return null;
           }

           @Override
           public Dimension getSize() {
               return null;
           }

           @Override
           public Rectangle getRect() {
               return null;
           }

           @Override
           public String getCssValue(String propertyName) {
               return null;
           }

           @Override
           public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
               return null;
           }
       };
       List<WebElement> textMessage = GlobalVariable.driver.findElements(By.className("_aok"));
       WebElement lastTextMessage = textMessage.get(textMessage.size() - 1);
       if (lMsg != lastTextMessage) {
           System.out.println(lastTextMessage.getText());
           lMsg = lastTextMessage;
       } else {
           System.out.println("no text");
       }


       //        TODO: image scrapper
   }

   //    Scrapes images
   protected static void imgScrapper(String[] args) {
       List<WebElement> lImg = new List<WebElement>() {
           @Override
           public int size() {
               return 0;
           }

           @Override
           public boolean isEmpty() {
               return false;
           }

           @Override
           public boolean contains(Object o) {
               return false;
           }

           @Override
           public Iterator<WebElement> iterator() {
               return null;
           }

           @Override
           public Object[] toArray() {
               return new Object[0];
           }

           @Override
           public <T> T[] toArray(T[] ts) {
               return null;
           }

           @Override
           public boolean add(WebElement webElement) {
               return false;
           }

           @Override
           public boolean remove(Object o) {
               return false;
           }

           @Override
           public boolean containsAll(Collection<?> collection) {
               return false;
           }

           @Override
           public boolean addAll(Collection<? extends WebElement> collection) {
               return false;
           }

           @Override
           public boolean addAll(int i, Collection<? extends WebElement> collection) {
               return false;
           }

           @Override
           public boolean removeAll(Collection<?> collection) {
               return false;
           }

           @Override
           public boolean retainAll(Collection<?> collection) {
               return false;
           }

           @Override
           public void clear() {

           }

           @Override
           public WebElement get(int i) {
               return null;
           }

           @Override
           public WebElement set(int i, WebElement webElement) {
               return null;
           }

           @Override
           public void add(int i, WebElement webElement) {

           }

           @Override
           public WebElement remove(int i) {
               return null;
           }

           @Override
           public int indexOf(Object o) {
               return 0;
           }

           @Override
           public int lastIndexOf(Object o) {
               return 0;
           }

           @Override
           public ListIterator<WebElement> listIterator() {
               return null;
           }

           @Override
           public ListIterator<WebElement> listIterator(int i) {
               return null;
           }

           @Override
           public List<WebElement> subList(int i, int i1) {
               return null;
           }
       };
       List<WebElement> img = GlobalVariable.driver.findElements(By.className("_4tsl"));
       if (lImg != img) {
           for (WebElement a : img) {
               System.out.println(a.getAttribute("href"));
           }
           lImg = img;
       }
   }

   //    Scrapes files
   protected static void fileScrapper(String[] args) {
       List<WebElement> lFile = new List<WebElement>() {
           @Override
           public int size() {
               return 0;
           }

           @Override
           public boolean isEmpty() {
               return false;
           }

           @Override
           public boolean contains(Object o) {
               return false;
           }

           @Override
           public Iterator<WebElement> iterator() {
               return null;
           }

           @Override
           public Object[] toArray() {
               return new Object[0];
           }

           @Override
           public <T> T[] toArray(T[] ts) {
               return null;
           }

           @Override
           public boolean add(WebElement webElement) {
               return false;
           }

           @Override
           public boolean remove(Object o) {
               return false;
           }

           @Override
           public boolean containsAll(Collection<?> collection) {
               return false;
           }

           @Override
           public boolean addAll(Collection<? extends WebElement> collection) {
               return false;
           }

           @Override
           public boolean addAll(int i, Collection<? extends WebElement> collection) {
               return false;
           }

           @Override
           public boolean removeAll(Collection<?> collection) {
               return false;
           }

           @Override
           public boolean retainAll(Collection<?> collection) {
               return false;
           }

           @Override
           public void clear() {

           }

           @Override
           public WebElement get(int i) {
               return null;
           }

           @Override
           public WebElement set(int i, WebElement webElement) {
               return null;
           }

           @Override
           public void add(int i, WebElement webElement) {

           }

           @Override
           public WebElement remove(int i) {
               return null;
           }

           @Override
           public int indexOf(Object o) {
               return 0;
           }

           @Override
           public int lastIndexOf(Object o) {
               return 0;
           }

           @Override
           public ListIterator<WebElement> listIterator() {
               return null;
           }

           @Override
           public ListIterator<WebElement> listIterator(int i) {
               return null;
           }

           @Override
           public List<WebElement> subList(int i, int i1) {
               return null;
           }
       };
       List<WebElement> file = GlobalVariable.driver.findElements(By.className("_4pcn"));
       if (lFile != file)
           for (WebElement a : file) {
               // Print out the URL of the anchor.
               System.out.println(a.getAttribute("href"));
           }
       lFile = file;
   }
*/



