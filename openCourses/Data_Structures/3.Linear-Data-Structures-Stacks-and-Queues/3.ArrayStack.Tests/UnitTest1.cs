using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using _3.ImplementArrayStack;

namespace _3.ArrayStack.Tests
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Push_EmptyStack_ShouldAddElement()
        {
            // Arrange
            var stack = new ArrayStack<int>();

            // Act

            stack.Push(5);

            // Assert
            Assert.AreEqual(1, stack.Count);
        }





    }
}
