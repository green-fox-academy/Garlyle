using EntityFramework;
using NUnit.Framework;

namespace EntityTest
{
    [TestFixture]
    public class FibonacciTest
    {
        [Test]
        public void TestCorrectNumber()
        {
            Assert.AreEqual(8, Program.fibonacci(6));
        }
        
        [Test]
        public void TestForZero()
        {
            Assert.AreEqual(0, Program.fibonacci(0));
        }

        [Test]
        public void TestForNegative()
        {
            Assert.AreEqual(0, Program.fibonacci(-20));
        }

    }
}