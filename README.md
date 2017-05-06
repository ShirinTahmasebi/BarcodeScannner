<html>

<div dir="rtl">
<h1> 
بارکد اسکنر
</h1>

برای خواندن بارکد و برگرداندن نتیجه آن، کتابخانه متن بازی بنام ZXing وجود دارد که در این برنامه به عنوان یک پکیج در کنار پکیج اصلی برنامه قرار داده شده است.

به این ترتیب کلیه مراحل اسکن از طریق دوربین، گرفتن کد و بازیابی اطلاعات مربوطه براحتی توسط این کتابخانه هندل میشود. برای اینکار صرفا با فراخوانی تکه کد زیر کار اسکن انجام میشود:  
</div>

``` java

IntentIntegrator scanIntegrator = new IntentIntegrator(this);
scanIntegrator.initiateScan();
```


<div dir="rtl">
از آنجا که کار اسکن توسط اپلیکیشن بارکد اسکنر انجام میشود، درصورت نصب نبودن این برنامه به کاربر پیامی نمایش داده و از او خواسته میشود که برنامه را نصب کند.
و برای بازیابی اطلاعات و نوع بار کد هم از تکه کد زیر استفاده میشود:
</div>


```java

IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
String scanContent = scanningResult.getContents();
String scanFormat = scanningResult.getFormatName();
```

<div dir="rtl">
حالا نکته‌ای که باید مورد توجه قرار بگیرد نحوه تولید بارکد برای انواع محصولات هست. البته بارکدها انواع متفاوتی دارند اما اینجا بیشتر به تولید بارکدهای QR میپردازم.
برای تولید این بارکدها میتوان از آدرس زیر استفاده کرد:
</div>

https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl=

<div dir="rtl">
توجه شود که در ادامه این URL باید محتوایی که میخواهیم با بارکد نمایش دهیم را بنویسیم. یعنی مثلا برای اینکه کلمه AndroidApplication  را کد کنیم میتوانیم از آدرس زیر استفاده کنیم:
</div>

https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl=AndroidApplication

<div dir="rtl">
به این ترتیب اگر بارکدی که از این آدرس به دست می‌آوریم را اسکن کنیم، در قسمت اطلاعات مربوط به کد بدست آمده، کلمه AndroidApplication نمایش داده خواهد شد.
</div>

</html>
